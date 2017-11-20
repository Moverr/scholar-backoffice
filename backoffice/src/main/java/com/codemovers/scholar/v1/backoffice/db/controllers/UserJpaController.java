/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import static com.codemovers.scholar.v1.backoffice.db.controllers.GeneralAccountJpaController.LOG;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author Mover 11/19/2017
 */
public class UserJpaController extends JpaController {

    protected static final Logger LOG = Logger.getLogger(UserJpaController.class.getName());

    private static UserJpaController controller = null;

    public static UserJpaController getInstance() {
        if (controller == null) {
            controller = new UserJpaController();
        }
        return controller;
    }

    public UserJpaController() {
        super(Users.class);
    }

    public Users create(Users entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception eml) {
            LOG.log(Level.INFO, eml.toString());
            throw eml;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;

    }

    public void edit(Users user) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            user = em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getId().intValue();
                if (findUser(id) == null) {
                    throw new BadRequestException("The mOffice with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Users findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    private List<Users> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
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

    public List<Users> findUserEntities() {
        return UserJpaController.this.findUserEntities(true, -1, -1);
    }

    public List<Users> findUserEntities(int maxResults, int firstResult) {
        return UserJpaController.this.findUserEntities(false, maxResults, firstResult);
    }

    public List<Users> findByUserName(String username) {
        List<Users> userList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Users.findByUsername");
        query.setParameter("username", username);
        try {
            userList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{username});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return userList;
    }

    public Users findByExternalId(String externalId) {
        Users userList = new Users();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByExternalId");
        query.setParameter("external_id", externalId);
        try {
            userList = (Users) query.getSingleResult();
            LOG.log(Level.FINE, "offices found for externalId {0}", new Object[]{externalId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return userList;
    }

//    public List<Users> findByHeirarchy(String heirarchy) {
//        List<Users> userList = new ArrayList<>();
//        EntityManager em = getEntityManager();
//        Query query = em.createNamedQuery("MOffice.findByHierarchy");
//        query.setParameter("hierarchy", heirarchy);
//        try {
//            userList = query.getResultList();
//            LOG.log(Level.FINE, "offices found for heirarchy {0}", new Object[]{heirarchy});
//        } catch (Exception ex) {
//            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
//            return null;
//            // don't throw WebApplicationException, force caller to handle this
//        } finally {
//            LOG.log(Level.FINER, "closing entity manager {0}", em);
//            em.close();
//        }
//        return userList;
//    }
//
//    public List<Users> findByParentId(String parentId) {
//        List<Users> userList = new ArrayList<>();
//        EntityManager em = getEntityManager();
//        Query query = em.createNamedQuery("MOffice.findByParentId");
//        query.setParameter("parent_id", parentId);
//        try {
//            userList = query.getResultList();
//            LOG.log(Level.FINE, "offices found for parentId {0}", new Object[]{parentId});
//        } catch (Exception ex) {
//            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
//            return null;
//            // don't throw WebApplicationException, force caller to handle this
//        } finally {
//            LOG.log(Level.FINER, "closing entity manager {0}", em);
//            em.close();
//        }
//        return userList;
//    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GeneralAccounts> rt = cq.from(GeneralAccounts.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return (Integer) q.getSingleResult();
        } finally {
            em.close();
        }
    }

}
