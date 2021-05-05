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
import org.jdeveloper.beans.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import org.jdeveloper.beans.Groupuser;
import org.jdeveloper.controller.exceptions.IllegalOrphanException;
import org.jdeveloper.controller.exceptions.NonexistentEntityException;
import org.jdeveloper.controller.exceptions.RollbackFailureException;

/**
 *
 * @author goudjanou
 */
public class GroupuserJpaController implements Serializable {

    public GroupuserJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Groupuser groupuser) throws RollbackFailureException, Exception {
        if (groupuser.getUserList() == null) {
            groupuser.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : groupuser.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getUserPK());
                attachedUserList.add(userListUserToAttach);
            }
            groupuser.setUserList(attachedUserList);
            em.persist(groupuser);
            for (User userListUser : groupuser.getUserList()) {
                Groupuser oldGroupuserOfUserListUser = userListUser.getGroupuser();
                userListUser.setGroupuser(groupuser);
                userListUser = em.merge(userListUser);
                if (oldGroupuserOfUserListUser != null) {
                    oldGroupuserOfUserListUser.getUserList().remove(userListUser);
                    oldGroupuserOfUserListUser = em.merge(oldGroupuserOfUserListUser);
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

    public void edit(Groupuser groupuser) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Groupuser persistentGroupuser = em.find(Groupuser.class, groupuser.getId());
            List<User> userListOld = persistentGroupuser.getUserList();
            List<User> userListNew = groupuser.getUserList();
            List<String> illegalOrphanMessages = null;
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain User " + userListOldUser + " since its groupuser field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getUserPK());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            groupuser.setUserList(userListNew);
            groupuser = em.merge(groupuser);
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Groupuser oldGroupuserOfUserListNewUser = userListNewUser.getGroupuser();
                    userListNewUser.setGroupuser(groupuser);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldGroupuserOfUserListNewUser != null && !oldGroupuserOfUserListNewUser.equals(groupuser)) {
                        oldGroupuserOfUserListNewUser.getUserList().remove(userListNewUser);
                        oldGroupuserOfUserListNewUser = em.merge(oldGroupuserOfUserListNewUser);
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
                Integer id = groupuser.getId();
                if (findGroupuser(id) == null) {
                    throw new NonexistentEntityException("The groupuser with id " + id + " no longer exists.");
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
            Groupuser groupuser;
            try {
                groupuser = em.getReference(Groupuser.class, id);
                groupuser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The groupuser with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<User> userListOrphanCheck = groupuser.getUserList();
            for (User userListOrphanCheckUser : userListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Groupuser (" + groupuser + ") cannot be destroyed since the User " + userListOrphanCheckUser + " in its userList field has a non-nullable groupuser field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(groupuser);
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

    public List<Groupuser> findGroupuserEntities() {
        return findGroupuserEntities(true, -1, -1);
    }

    public List<Groupuser> findGroupuserEntities(int maxResults, int firstResult) {
        return findGroupuserEntities(false, maxResults, firstResult);
    }

    private List<Groupuser> findGroupuserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Groupuser.class));
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

    public Groupuser findGroupuser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Groupuser.class, id);
        } finally {
            em.close();
        }
    }

    public int getGroupuserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Groupuser> rt = cq.from(Groupuser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
