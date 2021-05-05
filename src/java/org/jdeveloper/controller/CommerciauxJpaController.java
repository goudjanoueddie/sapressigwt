/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jdeveloper.beans.Prospection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Commerciaux;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class CommerciauxJpaController implements Serializable {

    public CommerciauxJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Commerciaux commerciaux) throws RollbackFailureException, Exception {
        if (commerciaux.getProspectionList() == null) {
            commerciaux.setProspectionList(new ArrayList<Prospection>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Prospection> attachedProspectionList = new ArrayList<Prospection>();
            for (Prospection prospectionListProspectionToAttach : commerciaux.getProspectionList()) {
                prospectionListProspectionToAttach = em.getReference(prospectionListProspectionToAttach.getClass(), prospectionListProspectionToAttach.getIdProspection());
                attachedProspectionList.add(prospectionListProspectionToAttach);
            }
            commerciaux.setProspectionList(attachedProspectionList);
            em.persist(commerciaux);
            for (Prospection prospectionListProspection : commerciaux.getProspectionList()) {
                Commerciaux oldIdCommerciauxOfProspectionListProspection = prospectionListProspection.getIdCommerciaux();
                prospectionListProspection.setIdCommerciaux(commerciaux);
                prospectionListProspection = em.merge(prospectionListProspection);
                if (oldIdCommerciauxOfProspectionListProspection != null) {
                    oldIdCommerciauxOfProspectionListProspection.getProspectionList().remove(prospectionListProspection);
                    oldIdCommerciauxOfProspectionListProspection = em.merge(oldIdCommerciauxOfProspectionListProspection);
                }
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

    public void edit(Commerciaux commerciaux) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Commerciaux persistentCommerciaux = em.find(Commerciaux.class, commerciaux.getIdCommerciaux());
            List<Prospection> prospectionListOld = persistentCommerciaux.getProspectionList();
            List<Prospection> prospectionListNew = commerciaux.getProspectionList();
            List<String> illegalOrphanMessages = null;
            for (Prospection prospectionListOldProspection : prospectionListOld) {
                if (!prospectionListNew.contains(prospectionListOldProspection)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Prospection " + prospectionListOldProspection + " since its idCommerciaux field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Prospection> attachedProspectionListNew = new ArrayList<Prospection>();
            for (Prospection prospectionListNewProspectionToAttach : prospectionListNew) {
                prospectionListNewProspectionToAttach = em.getReference(prospectionListNewProspectionToAttach.getClass(), prospectionListNewProspectionToAttach.getIdProspection());
                attachedProspectionListNew.add(prospectionListNewProspectionToAttach);
            }
            prospectionListNew = attachedProspectionListNew;
            commerciaux.setProspectionList(prospectionListNew);
            commerciaux = em.merge(commerciaux);
            for (Prospection prospectionListNewProspection : prospectionListNew) {
                if (!prospectionListOld.contains(prospectionListNewProspection)) {
                    Commerciaux oldIdCommerciauxOfProspectionListNewProspection = prospectionListNewProspection.getIdCommerciaux();
                    prospectionListNewProspection.setIdCommerciaux(commerciaux);
                    prospectionListNewProspection = em.merge(prospectionListNewProspection);
                    if (oldIdCommerciauxOfProspectionListNewProspection != null && !oldIdCommerciauxOfProspectionListNewProspection.equals(commerciaux)) {
                        oldIdCommerciauxOfProspectionListNewProspection.getProspectionList().remove(prospectionListNewProspection);
                        oldIdCommerciauxOfProspectionListNewProspection = em.merge(oldIdCommerciauxOfProspectionListNewProspection);
                    }
                }
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
                Integer id = commerciaux.getIdCommerciaux();
                if (findCommerciaux(id) == null) {
                    throw new NonexistentEntityException("The commerciaux with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Commerciaux commerciaux;
            try {
                commerciaux = em.getReference(Commerciaux.class, id);
                commerciaux.getIdCommerciaux();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The commerciaux with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Prospection> prospectionListOrphanCheck = commerciaux.getProspectionList();
            for (Prospection prospectionListOrphanCheckProspection : prospectionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Commerciaux (" + commerciaux + ") cannot be destroyed since the Prospection " + prospectionListOrphanCheckProspection + " in its prospectionList field has a non-nullable idCommerciaux field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(commerciaux);
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

    public List<Commerciaux> findCommerciauxEntities() {
        return findCommerciauxEntities(true, -1, -1);
    }

    public List<Commerciaux> findCommerciauxEntities(int maxResults, int firstResult) {
        return findCommerciauxEntities(false, maxResults, firstResult);
    }

    private List<Commerciaux> findCommerciauxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Commerciaux.class));
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

    public Commerciaux findCommerciaux(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Commerciaux.class, id);
        } finally {
            em.close();
        }
    }

    public int getCommerciauxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Commerciaux> rt = cq.from(Commerciaux.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
