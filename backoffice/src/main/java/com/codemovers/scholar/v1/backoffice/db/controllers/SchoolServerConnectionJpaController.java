/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.SchoolServerConnection;
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
 * @author Mover 11/26/2017
 */
public class SchoolServerConnectionJpaController extends JpaController {

    protected static final Logger LOG = Logger.getLogger(SchoolServerConnectionJpaController.class.getName());

    private static SchoolServerConnectionJpaController controller = null;

    public static SchoolServerConnectionJpaController getInstance() {
        if (controller == null) {
            controller = new SchoolServerConnectionJpaController();
        }
        return controller;
    }

    public SchoolServerConnectionJpaController() {
        super(SchoolServerConnection.class);
    }

    public SchoolServerConnection create(SchoolServerConnection entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception eml) {
            LOG.log(Level.INFO, "ERROR  SERVER CONNECTION {0} ", Utilities.getStackTrace(eml));
            throw eml;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return entity;
    }

    public void edit(SchoolServerConnection server_connection) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            server_connection = em.merge(server_connection);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = server_connection.getId().intValue();
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

    public SchoolServerConnection findById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SchoolServerConnection.class, id);
        } finally {
            em.close();
        }
    }

    private List<SchoolServerConnection> findSchoolConnectionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SchoolServerConnection.class));
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

    public List<SchoolServerConnection> findSchoolConnectionEntities() {
        return findSchoolConnectionEntities(true, -1, -1);
    }

    public List<SchoolServerConnection> findSchoolConnectionEntities(int maxResults, int firstResult) {
        return findSchoolConnectionEntities(false, maxResults, firstResult);
    }

    public List<SchoolServerConnection> findByAccountId(Integer schoolAccountId) {
        List<SchoolServerConnection> serverConnectionList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("SchoolServerConnection.findByAccountid");
        query.setParameter("schoolAccountId", schoolAccountId);
        try {
            serverConnectionList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{schoolAccountId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return serverConnectionList;
    }


}
