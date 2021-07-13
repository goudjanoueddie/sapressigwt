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
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Demandestraites;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class DemandestraitesJpaController implements Serializable {

    
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;
    
    public DemandestraitesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DemandestraitesJpaController() {
        emf= Persistence.createEntityManagerFactory("TableaudeBordSapressiPU");
    }
    
    

    public void create(Demandestraites demandestraites) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(demandestraites);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                //utx.rollback();
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

    public void edit(Demandestraites demandestraites) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            demandestraites = em.merge(demandestraites);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = demandestraites.getId();
                if (findDemandestraites(id) == null) {
                    throw new NonexistentEntityException("The demandestraites with id " + id + " no longer exists.");
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
            Demandestraites demandestraites;
            try {
                demandestraites = em.getReference(Demandestraites.class, id);
                demandestraites.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The demandestraites with id " + id + " no longer exists.", enfe);
            }
            em.remove(demandestraites);
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

    public List<Demandestraites> findDemandestraitesEntities() {
        return findDemandestraitesEntities(true, -1, -1);
    }

    public List<Demandestraites> findDemandestraitesEntities(int maxResults, int firstResult) {
        return findDemandestraitesEntities(false, maxResults, firstResult);
    }

    private List<Demandestraites> findDemandestraitesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Demandestraites.class));
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

    public Demandestraites findDemandestraites(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Demandestraites.class, id);
        } finally {
            em.close();
        }
    }

    public int getDemandestraitesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Demandestraites> rt = cq.from(Demandestraites.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
