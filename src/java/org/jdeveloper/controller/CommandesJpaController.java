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
import org.jdeveloper.beans.Clients;
import org.jdeveloper.beans.Factures;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Commandes;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class CommandesJpaController implements Serializable {

    public CommandesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Commandes commandes) throws RollbackFailureException, Exception {
        if (commandes.getFacturesList() == null) {
            commandes.setFacturesList(new ArrayList<Factures>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Clients idClients = commandes.getIdClients();
            if (idClients != null) {
                idClients = em.getReference(idClients.getClass(), idClients.getIdClients());
                commandes.setIdClients(idClients);
            }
            List<Factures> attachedFacturesList = new ArrayList<Factures>();
            for (Factures facturesListFacturesToAttach : commandes.getFacturesList()) {
                facturesListFacturesToAttach = em.getReference(facturesListFacturesToAttach.getClass(), facturesListFacturesToAttach.getIdFacture());
                attachedFacturesList.add(facturesListFacturesToAttach);
            }
            commandes.setFacturesList(attachedFacturesList);
            em.persist(commandes);
            if (idClients != null) {
                idClients.getCommandesList().add(commandes);
                idClients = em.merge(idClients);
            }
            for (Factures facturesListFactures : commandes.getFacturesList()) {
                Commandes oldIdCommandeOfFacturesListFactures = facturesListFactures.getIdCommande();
                facturesListFactures.setIdCommande(commandes);
                facturesListFactures = em.merge(facturesListFactures);
                if (oldIdCommandeOfFacturesListFactures != null) {
                    oldIdCommandeOfFacturesListFactures.getFacturesList().remove(facturesListFactures);
                    oldIdCommandeOfFacturesListFactures = em.merge(oldIdCommandeOfFacturesListFactures);
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

    public void edit(Commandes commandes) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Commandes persistentCommandes = em.find(Commandes.class, commandes.getIdCommande());
            Clients idClientsOld = persistentCommandes.getIdClients();
            Clients idClientsNew = commandes.getIdClients();
            List<Factures> facturesListOld = persistentCommandes.getFacturesList();
            List<Factures> facturesListNew = commandes.getFacturesList();
            List<String> illegalOrphanMessages = null;
            for (Factures facturesListOldFactures : facturesListOld) {
                if (!facturesListNew.contains(facturesListOldFactures)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factures " + facturesListOldFactures + " since its idCommande field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClientsNew != null) {
                idClientsNew = em.getReference(idClientsNew.getClass(), idClientsNew.getIdClients());
                commandes.setIdClients(idClientsNew);
            }
            List<Factures> attachedFacturesListNew = new ArrayList<Factures>();
            for (Factures facturesListNewFacturesToAttach : facturesListNew) {
                facturesListNewFacturesToAttach = em.getReference(facturesListNewFacturesToAttach.getClass(), facturesListNewFacturesToAttach.getIdFacture());
                attachedFacturesListNew.add(facturesListNewFacturesToAttach);
            }
            facturesListNew = attachedFacturesListNew;
            commandes.setFacturesList(facturesListNew);
            commandes = em.merge(commandes);
            if (idClientsOld != null && !idClientsOld.equals(idClientsNew)) {
                idClientsOld.getCommandesList().remove(commandes);
                idClientsOld = em.merge(idClientsOld);
            }
            if (idClientsNew != null && !idClientsNew.equals(idClientsOld)) {
                idClientsNew.getCommandesList().add(commandes);
                idClientsNew = em.merge(idClientsNew);
            }
            for (Factures facturesListNewFactures : facturesListNew) {
                if (!facturesListOld.contains(facturesListNewFactures)) {
                    Commandes oldIdCommandeOfFacturesListNewFactures = facturesListNewFactures.getIdCommande();
                    facturesListNewFactures.setIdCommande(commandes);
                    facturesListNewFactures = em.merge(facturesListNewFactures);
                    if (oldIdCommandeOfFacturesListNewFactures != null && !oldIdCommandeOfFacturesListNewFactures.equals(commandes)) {
                        oldIdCommandeOfFacturesListNewFactures.getFacturesList().remove(facturesListNewFactures);
                        oldIdCommandeOfFacturesListNewFactures = em.merge(oldIdCommandeOfFacturesListNewFactures);
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
                Integer id = commandes.getIdCommande();
                if (findCommandes(id) == null) {
                    throw new NonexistentEntityException("The commandes with id " + id + " no longer exists.");
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
            Commandes commandes;
            try {
                commandes = em.getReference(Commandes.class, id);
                commandes.getIdCommande();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The commandes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Factures> facturesListOrphanCheck = commandes.getFacturesList();
            for (Factures facturesListOrphanCheckFactures : facturesListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Commandes (" + commandes + ") cannot be destroyed since the Factures " + facturesListOrphanCheckFactures + " in its facturesList field has a non-nullable idCommande field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Clients idClients = commandes.getIdClients();
            if (idClients != null) {
                idClients.getCommandesList().remove(commandes);
                idClients = em.merge(idClients);
            }
            em.remove(commandes);
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

    public List<Commandes> findCommandesEntities() {
        return findCommandesEntities(true, -1, -1);
    }

    public List<Commandes> findCommandesEntities(int maxResults, int firstResult) {
        return findCommandesEntities(false, maxResults, firstResult);
    }

    private List<Commandes> findCommandesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Commandes.class));
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

    public Commandes findCommandes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Commandes.class, id);
        } finally {
            em.close();
        }
    }

    public int getCommandesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Commandes> rt = cq.from(Commandes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
