/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
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
public class GeneralAccountJpaController extends JpaController {

    protected static final Logger LOG = Logger.getLogger(GeneralAccountJpaController.class.getName());

    private static GeneralAccountJpaController controller = null;

    public static GeneralAccountJpaController getInstance() {
        if (controller == null) {
            controller = new GeneralAccountJpaController();
        }
        return controller;
    }


    public GeneralAccountJpaController() {
        super(GeneralAccounts.class);
    }

    public GeneralAccounts create(GeneralAccounts entity) {
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

    public void edit(GeneralAccounts account) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            account = em.merge(account);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = account.getId().intValue();
                if (findAccount(id) == null) {
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

    public GeneralAccounts findAccount(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GeneralAccounts.class, id);
        } finally {
            em.close();
        }
    }

    private List<GeneralAccounts> findAccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GeneralAccounts.class));
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

    public List<GeneralAccounts> findAccountEntities() {
        return findAccountEntities(true, -1, -1);
    }

    public List<GeneralAccounts> findMOfficeEntities(int maxResults, int firstResult) {
        return findAccountEntities(false, maxResults, firstResult);
    }

    public List<GeneralAccounts> findByName(String name) {
        List<GeneralAccounts> mOfficeList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByName");
        query.setParameter("name", name);
        try {
            mOfficeList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{name});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return mOfficeList;
    }

    public GeneralAccounts findByExternalId(String externalId) {
        GeneralAccounts mOffice = new GeneralAccounts();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByExternalId");
        query.setParameter("external_id", externalId);
        try {
            mOffice = (GeneralAccounts) query.getSingleResult();
            LOG.log(Level.FINE, "offices found for externalId {0}", new Object[]{externalId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return mOffice;
    }

    public List<GeneralAccounts> findByHeirarchy(String heirarchy) {
        List<GeneralAccounts> mOfficeList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByHierarchy");
        query.setParameter("hierarchy", heirarchy);
        try {
            mOfficeList = query.getResultList();
            LOG.log(Level.FINE, "offices found for heirarchy {0}", new Object[]{heirarchy});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return mOfficeList;
    }

    public List<GeneralAccounts> findByParentId(String parentId) {
        List<GeneralAccounts> mOfficeList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByParentId");
        query.setParameter("parent_id", parentId);
        try {
            mOfficeList = query.getResultList();
            LOG.log(Level.FINE, "offices found for parentId {0}", new Object[]{parentId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return mOfficeList;
    }

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
