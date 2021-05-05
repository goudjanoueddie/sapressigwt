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
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Prospection;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
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
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clients clients) throws RollbackFailureException, Exception {
        if (clients.getCommandesList() == null) {
            clients.setCommandesList(new ArrayList<Commandes>());
        }
        if (clients.getProspectionList() == null) {
            clients.setProspectionList(new ArrayList<Prospection>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Commandes> attachedCommandesList = new ArrayList<Commandes>();
            for (Commandes commandesListCommandesToAttach : clients.getCommandesList()) {
                commandesListCommandesToAttach = em.getReference(commandesListCommandesToAttach.getClass(), commandesListCommandesToAttach.getIdCommande());
                attachedCommandesList.add(commandesListCommandesToAttach);
            }
            clients.setCommandesList(attachedCommandesList);
            List<Prospection> attachedProspectionList = new ArrayList<Prospection>();
            for (Prospection prospectionListProspectionToAttach : clients.getProspectionList()) {
                prospectionListProspectionToAttach = em.getReference(prospectionListProspectionToAttach.getClass(), prospectionListProspectionToAttach.getIdProspection());
                attachedProspectionList.add(prospectionListProspectionToAttach);
            }
            clients.setProspectionList(attachedProspectionList);
            em.persist(clients);
            for (Commandes commandesListCommandes : clients.getCommandesList()) {
                Clients oldIdClientsOfCommandesListCommandes = commandesListCommandes.getIdClients();
                commandesListCommandes.setIdClients(clients);
                commandesListCommandes = em.merge(commandesListCommandes);
                if (oldIdClientsOfCommandesListCommandes != null) {
                    oldIdClientsOfCommandesListCommandes.getCommandesList().remove(commandesListCommandes);
                    oldIdClientsOfCommandesListCommandes = em.merge(oldIdClientsOfCommandesListCommandes);
                }
            }
            for (Prospection prospectionListProspection : clients.getProspectionList()) {
                Clients oldIdClientsOfProspectionListProspection = prospectionListProspection.getIdClients();
                prospectionListProspection.setIdClients(clients);
                prospectionListProspection = em.merge(prospectionListProspection);
                if (oldIdClientsOfProspectionListProspection != null) {
                    oldIdClientsOfProspectionListProspection.getProspectionList().remove(prospectionListProspection);
                    oldIdClientsOfProspectionListProspection = em.merge(oldIdClientsOfProspectionListProspection);
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

    public void edit(Clients clients) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Clients persistentClients = em.find(Clients.class, clients.getIdClients());
            List<Commandes> commandesListOld = persistentClients.getCommandesList();
            List<Commandes> commandesListNew = clients.getCommandesList();
            List<Prospection> prospectionListOld = persistentClients.getProspectionList();
            List<Prospection> prospectionListNew = clients.getProspectionList();
            List<String> illegalOrphanMessages = null;
            for (Commandes commandesListOldCommandes : commandesListOld) {
                if (!commandesListNew.contains(commandesListOldCommandes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Commandes " + commandesListOldCommandes + " since its idClients field is not nullable.");
                }
            }
            for (Prospection prospectionListOldProspection : prospectionListOld) {
                if (!prospectionListNew.contains(prospectionListOldProspection)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Prospection " + prospectionListOldProspection + " since its idClients field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Commandes> attachedCommandesListNew = new ArrayList<Commandes>();
            for (Commandes commandesListNewCommandesToAttach : commandesListNew) {
                commandesListNewCommandesToAttach = em.getReference(commandesListNewCommandesToAttach.getClass(), commandesListNewCommandesToAttach.getIdCommande());
                attachedCommandesListNew.add(commandesListNewCommandesToAttach);
            }
            commandesListNew = attachedCommandesListNew;
            clients.setCommandesList(commandesListNew);
            List<Prospection> attachedProspectionListNew = new ArrayList<Prospection>();
            for (Prospection prospectionListNewProspectionToAttach : prospectionListNew) {
                prospectionListNewProspectionToAttach = em.getReference(prospectionListNewProspectionToAttach.getClass(), prospectionListNewProspectionToAttach.getIdProspection());
                attachedProspectionListNew.add(prospectionListNewProspectionToAttach);
            }
            prospectionListNew = attachedProspectionListNew;
            clients.setProspectionList(prospectionListNew);
            clients = em.merge(clients);
            for (Commandes commandesListNewCommandes : commandesListNew) {
                if (!commandesListOld.contains(commandesListNewCommandes)) {
                    Clients oldIdClientsOfCommandesListNewCommandes = commandesListNewCommandes.getIdClients();
                    commandesListNewCommandes.setIdClients(clients);
                    commandesListNewCommandes = em.merge(commandesListNewCommandes);
                    if (oldIdClientsOfCommandesListNewCommandes != null && !oldIdClientsOfCommandesListNewCommandes.equals(clients)) {
                        oldIdClientsOfCommandesListNewCommandes.getCommandesList().remove(commandesListNewCommandes);
                        oldIdClientsOfCommandesListNewCommandes = em.merge(oldIdClientsOfCommandesListNewCommandes);
                    }
                }
            }
            for (Prospection prospectionListNewProspection : prospectionListNew) {
                if (!prospectionListOld.contains(prospectionListNewProspection)) {
                    Clients oldIdClientsOfProspectionListNewProspection = prospectionListNewProspection.getIdClients();
                    prospectionListNewProspection.setIdClients(clients);
                    prospectionListNewProspection = em.merge(prospectionListNewProspection);
                    if (oldIdClientsOfProspectionListNewProspection != null && !oldIdClientsOfProspectionListNewProspection.equals(clients)) {
                        oldIdClientsOfProspectionListNewProspection.getProspectionList().remove(prospectionListNewProspection);
                        oldIdClientsOfProspectionListNewProspection = em.merge(oldIdClientsOfProspectionListNewProspection);
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
                Integer id = clients.getIdClients();
                if (findClients(id) == null) {
                    throw new NonexistentEntityException("The clients with id " + id + " no longer exists.");
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
            Clients clients;
            try {
                clients = em.getReference(Clients.class, id);
                clients.getIdClients();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clients with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Commandes> commandesListOrphanCheck = clients.getCommandesList();
            for (Commandes commandesListOrphanCheckCommandes : commandesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clients (" + clients + ") cannot be destroyed since the Commandes " + commandesListOrphanCheckCommandes + " in its commandesList field has a non-nullable idClients field.");
            }
            List<Prospection> prospectionListOrphanCheck = clients.getProspectionList();
            for (Prospection prospectionListOrphanCheckProspection : prospectionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clients (" + clients + ") cannot be destroyed since the Prospection " + prospectionListOrphanCheckProspection + " in its prospectionList field has a non-nullable idClients field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(clients);
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
    
}
