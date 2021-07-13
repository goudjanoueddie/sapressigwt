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
import org.jdeveloper.beans.Parametreentreprise;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class ParametreentrepriseJpaController implements Serializable {
    
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public ParametreentrepriseJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    public ParametreentrepriseJpaController(){
        emf = Persistence.createEntityManagerFactory("TableaudeBordSapressiPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Parametreentreprise parametreentreprise) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(parametreentreprise);
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

    public void edit(Parametreentreprise parametreentreprise) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            parametreentreprise = em.merge(parametreentreprise);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = parametreentreprise.getId();
                if (findParametreentreprise(id) == null) {
                    throw new NonexistentEntityException("The parametreentreprise with id " + id + " no longer exists.");
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
            Parametreentreprise parametreentreprise;
            try {
                parametreentreprise = em.getReference(Parametreentreprise.class, id);
                parametreentreprise.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parametreentreprise with id " + id + " no longer exists.", enfe);
            }
            em.remove(parametreentreprise);
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

    public List<Parametreentreprise> findParametreentrepriseEntities() {
        return findParametreentrepriseEntities(true, -1, -1);
    }

    public List<Parametreentreprise> findParametreentrepriseEntities(int maxResults, int firstResult) {
        return findParametreentrepriseEntities(false, maxResults, firstResult);
    }

    private List<Parametreentreprise> findParametreentrepriseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Parametreentreprise.class));
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

    public Parametreentreprise findParametreentreprise(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Parametreentreprise.class, id);
        } finally {
            em.close();
        }
    }

    public int getParametreentrepriseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Parametreentreprise> rt = cq.from(Parametreentreprise.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
