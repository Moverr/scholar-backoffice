/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.SchoolAccount;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author Mover 11/24/2017
 */
public class SchoolAccountJpaController extends JpaController {

    protected static final Logger LOG = Logger.getLogger(UserRoleJpaController.class.getName());

    private static SchoolAccountJpaController controller = null;

    public static SchoolAccountJpaController getInstance() {
        if (controller == null) {
            controller = new SchoolAccountJpaController();
        }
        return controller;
    }

    public SchoolAccountJpaController() {
        super(SchoolAccount.class);
    }

    public SchoolAccount create(SchoolAccount entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception eml) {
            LOG.log(Level.INFO, "ERROR SCHOOL ACCOUNT {0} ", Utilities.getStackTrace(eml));
            throw eml;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }

    public void edit(SchoolAccount school_account) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            school_account = em.merge(school_account);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = school_account.getId().intValue();
                if (findById(id) == null) {
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

    public SchoolAccount findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SchoolAccount.class, id);
        } finally {
            em.close();
        }
    }

    private List<SchoolAccount> findSchoolAccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SchoolAccount.class));
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

    public List<SchoolAccount> findSchoolAccountEntities() {
        return findSchoolAccountEntities(true, -1, -1);
    }

    public List<SchoolAccount> findSchoolAccountEntities(int maxResults, int firstResult) {
        return findSchoolAccountEntities(false, maxResults, firstResult);
    }

    public List<SchoolAccount> findByName(String name) {
        List<SchoolAccount> schoolAccountList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("SchoolAccount.findByName");
        query.setParameter("name", name);
        try {
            schoolAccountList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{name});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return schoolAccountList;
    }


}
