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
import org.jdeveloper.beans.Commandes;
import org.jdeveloper.beans.Factures;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class FacturesJpaController implements Serializable {

    public FacturesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factures factures) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Commandes idCommande = factures.getIdCommande();
            if (idCommande != null) {
                idCommande = em.getReference(idCommande.getClass(), idCommande.getIdCommande());
                factures.setIdCommande(idCommande);
            }
            em.persist(factures);
            if (idCommande != null) {
                idCommande.getFacturesList().add(factures);
                idCommande = em.merge(idCommande);
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

    public void edit(Factures factures) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Factures persistentFactures = em.find(Factures.class, factures.getIdFacture());
            Commandes idCommandeOld = persistentFactures.getIdCommande();
            Commandes idCommandeNew = factures.getIdCommande();
            if (idCommandeNew != null) {
                idCommandeNew = em.getReference(idCommandeNew.getClass(), idCommandeNew.getIdCommande());
                factures.setIdCommande(idCommandeNew);
            }
            factures = em.merge(factures);
            if (idCommandeOld != null && !idCommandeOld.equals(idCommandeNew)) {
                idCommandeOld.getFacturesList().remove(factures);
                idCommandeOld = em.merge(idCommandeOld);
            }
            if (idCommandeNew != null && !idCommandeNew.equals(idCommandeOld)) {
                idCommandeNew.getFacturesList().add(factures);
                idCommandeNew = em.merge(idCommandeNew);
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
                Integer id = factures.getIdFacture();
                if (findFactures(id) == null) {
                    throw new NonexistentEntityException("The factures with id " + id + " no longer exists.");
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
            Factures factures;
            try {
                factures = em.getReference(Factures.class, id);
                factures.getIdFacture();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factures with id " + id + " no longer exists.", enfe);
            }
            Commandes idCommande = factures.getIdCommande();
            if (idCommande != null) {
                idCommande.getFacturesList().remove(factures);
                idCommande = em.merge(idCommande);
            }
            em.remove(factures);
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

    public List<Factures> findFacturesEntities() {
        return findFacturesEntities(true, -1, -1);
    }

    public List<Factures> findFacturesEntities(int maxResults, int firstResult) {
        return findFacturesEntities(false, maxResults, firstResult);
    }

    private List<Factures> findFacturesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factures.class));
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

    public Factures findFactures(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factures.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factures> rt = cq.from(Factures.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
