/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdeveloper.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Groupuser;
import org.jdeveloper.beans.User;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.PreexistingEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class UserJpaController implements Serializable {

    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;
    
    public UserJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public UserJpaController(){
        emf = Persistence.createEntityManagerFactory("TableaudeBordSapressiPU");
    }

    public void create(User user) throws PreexistingEntityException, RollbackFailureException, Exception {
        
        EntityManager em = null;
        try{
            em=getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        
        }catch (Exception ex) {
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

    public void edit(User user) throws NonexistentEntityException, RollbackFailureException, Exception {
        
    }

    public void destroy(Integer userId) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        
          EntityManager em = null;
        try{
            em=getEntityManager();
            em.getTransaction().begin();
            User user;
            user = em.getReference(User.class, userId);
            user.getId();
            em.remove(user);
            em.getTransaction().commit();
        
        }catch (Exception ex) {
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
        
        /*EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            User user;
            try {
                user = em.getReference(User.class, userId);
                user.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The groupuser with id " + userId + " no longer exists.", enfe);
            }
            
            em.remove(user);
            utx.commit();
            }
           
         catch (Exception ex) {
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
        }*/
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(User id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<String> getAllNames(){
        
        EntityManager em = getEntityManager();
        List userListe;
        
        try{
            
            StringBuffer queryString = new StringBuffer();
            queryString.append("select utilisateurs.userName from User utilisateurs");
            Query query = em.createQuery(queryString.toString());
            userListe = query.getResultList();
        
        }finally{
            em.close();
        }
        return userListe;
    }
    
    public Integer getIdUser(String userName){
    
        EntityManager em = getEntityManager();
        int idUser;
        
        try{
            idUser = (Integer)em.createNamedQuery("User.findByUserNameParameter").setParameter("userName", userName)
                    .getSingleResult();
            return idUser;
        }finally{
            em.close();
        }
    }
    
}
