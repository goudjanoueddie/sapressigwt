/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Commerciaux;
import org.jdeveloper.beans.Prospection;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class ProspectionJpaController implements Serializable {

    public ProspectionJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prospection prospection) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Clients idClients = prospection.getIdClients();
            if (idClients != null) {
                idClients = em.getReference(idClients.getClass(), idClients.getIdClients());
                prospection.setIdClients(idClients);
            }
            Commerciaux idCommerciaux = prospection.getIdCommerciaux();
            if (idCommerciaux != null) {
                idCommerciaux = em.getReference(idCommerciaux.getClass(), idCommerciaux.getIdCommerciaux());
                prospection.setIdCommerciaux(idCommerciaux);
            }
            em.persist(prospection);
            if (idClients != null) {
                idClients.getProspectionList().add(prospection);
                idClients = em.merge(idClients);
            }
            if (idCommerciaux != null) {
                idCommerciaux.getProspectionList().add(prospection);
                idCommerciaux = em.merge(idCommerciaux);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prospection prospection) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Prospection persistentProspection = em.find(Prospection.class, prospection.getIdProspection());
            Clients idClientsOld = persistentProspection.getIdClients();
            Clients idClientsNew = prospection.getIdClients();
            Commerciaux idCommerciauxOld = persistentProspection.getIdCommerciaux();
            Commerciaux idCommerciauxNew = prospection.getIdCommerciaux();
            if (idClientsNew != null) {
                idClientsNew = em.getReference(idClientsNew.getClass(), idClientsNew.getIdClients());
                prospection.setIdClients(idClientsNew);
            }
            if (idCommerciauxNew != null) {
                idCommerciauxNew = em.getReference(idCommerciauxNew.getClass(), idCommerciauxNew.getIdCommerciaux());
                prospection.setIdCommerciaux(idCommerciauxNew);
            }
            prospection = em.merge(prospection);
            if (idClientsOld != null && !idClientsOld.equals(idClientsNew)) {
                idClientsOld.getProspectionList().remove(prospection);
                idClientsOld = em.merge(idClientsOld);
            }
            if (idClientsNew != null && !idClientsNew.equals(idClientsOld)) {
                idClientsNew.getProspectionList().add(prospection);
                idClientsNew = em.merge(idClientsNew);
            }
            if (idCommerciauxOld != null && !idCommerciauxOld.equals(idCommerciauxNew)) {
                idCommerciauxOld.getProspectionList().remove(prospection);
                idCommerciauxOld = em.merge(idCommerciauxOld);
            }
            if (idCommerciauxNew != null && !idCommerciauxNew.equals(idCommerciauxOld)) {
                idCommerciauxNew.getProspectionList().add(prospection);
                idCommerciauxNew = em.merge(idCommerciauxNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = prospection.getIdProspection();
                if (findProspection(id) == null) {
                    throw new NonexistentEntityException("The prospection with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Prospection prospection;
            try {
                prospection = em.getReference(Prospection.class, id);
                prospection.getIdProspection();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prospection with id " + id + " no longer exists.", enfe);
            }
            Clients idClients = prospection.getIdClients();
            if (idClients != null) {
                idClients.getProspectionList().remove(prospection);
                idClients = em.merge(idClients);
            }
            Commerciaux idCommerciaux = prospection.getIdCommerciaux();
            if (idCommerciaux != null) {
                idCommerciaux.getProspectionList().remove(prospection);
                idCommerciaux = em.merge(idCommerciaux);
            }
            em.remove(prospection);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prospection> findProspectionEntities() {
        return findProspectionEntities(true, -1, -1);
    }

    public List<Prospection> findProspectionEntities(int maxResults, int firstResult) {
        return findProspectionEntities(false, maxResults, firstResult);
    }

    private List<Prospection> findProspectionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prospection.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Prospection findProspection(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prospection.class, id);
        } finally {
            em.close();
        }
    }

    public int getProspectionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prospection> rt = cq.from(Prospection.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
