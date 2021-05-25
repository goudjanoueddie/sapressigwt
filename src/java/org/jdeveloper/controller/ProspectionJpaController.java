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
        
    }

    public void edit(Prospection prospection) throws NonexistentEntityException, RollbackFailureException, Exception {
        
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        
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
