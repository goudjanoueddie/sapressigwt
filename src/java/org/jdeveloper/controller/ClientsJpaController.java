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
import org.jdeveloper.beans.Commandes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Prospection;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.PreexistingEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class ClientsJpaController implements Serializable {
    
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public ClientsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    public ClientsJpaController() {
       emf = Persistence.createEntityManagerFactory("TableaudeBordSapressiPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clients clients) throws PreexistingEntityException,RollbackFailureException, Exception {
        
         EntityManager em = null;
        try{
            em=getEntityManager();
            em.getTransaction().begin();
            em.persist(clients);
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

    public void edit(Clients clients) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        
    }

    public List<Clients> findClientsEntities() {
        return findClientsEntities(true, -1, -1);
    }

    public List<Clients> findClientsEntities(int maxResults, int firstResult) {
        return findClientsEntities(false, maxResults, firstResult);
    }

    private List<Clients> findClientsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clients.class));
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

    public Clients findClients(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clients.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clients> rt = cq.from(Clients.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<String> getAllClientsNames(){
        
        EntityManager em = getEntityManager();
        List clientsListe;
        
        try{
            
            StringBuffer queryString = new StringBuffer();
            queryString.append("select clients.nomClient from Clients clients");
            Query query = em.createQuery(queryString.toString());
            clientsListe = query.getResultList();
        
        }finally{
            em.close();
        }
        return clientsListe;
    }
    
    public Integer getIdClient(String clientName){
    
        EntityManager em = getEntityManager();
        int idUser;
        
        try{
            idUser = (Integer)em.createNamedQuery("Clients.findByClientNameParameter").setParameter("nomClient", clientName)
                    .getSingleResult();
            return idUser;
        }finally{
            em.close();
        }
    }
    
}
