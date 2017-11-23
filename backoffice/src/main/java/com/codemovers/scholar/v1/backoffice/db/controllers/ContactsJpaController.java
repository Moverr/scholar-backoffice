/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.Contacts;
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
 * @author Mover 11/23/2017
 */
public class ContactsJpaController extends JpaController {

    protected static final Logger LOG = Logger.getLogger(ContactsJpaController.class.getName());

    private static ContactsJpaController controller = null;

    public static ContactsJpaController getInstance() {
        if (controller == null) {
            controller = new ContactsJpaController();
        }
        return controller;
    }

    public ContactsJpaController() {
        super(Contacts.class);
    }

    public Contacts create(Contacts entity) {
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

    public void edit(Contacts contact) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contact = em.merge(contact);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = contact.getId().intValue();
                if (findContact(id) == null) {
                    throw new BadRequestException("The Contact with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public GeneralAccounts findContact(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GeneralAccounts.class, id);
        } finally {
            em.close();
        }
    }

    private List<Contacts> findContactEntities(boolean all, int maxResults, int firstResult) {
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

    public List<Contacts> findContactEntities() {
        return ContactsJpaController.this.findContactEntities(true, -1, -1);
    }

    public List<Contacts> findContactEntities(int maxResults, int firstResult) {
        return ContactsJpaController.this.findContactEntities(false, maxResults, firstResult);
    }

    // find contacts by parent types
    public List<GeneralAccounts> findContact(String parentType) {
        List<GeneralAccounts> generalAccountList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByName");
        query.setParameter("name", parentType);
        try {
            generalAccountList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{parentType});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return generalAccountList;
    }

    // find contacts by parent type and parent id
    public List<GeneralAccounts> findContact(String parentType, Integer parentId) {
        List<GeneralAccounts> generalAccountList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByName");
        query.setParameter("name", parentType);
        try {
            generalAccountList = query.getResultList();
            LOG.log(Level.FINE, "offices found for username {0}", new Object[]{parentType});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return generalAccountList;
    }


    public GeneralAccounts findByExternalId(String externalId) {
        GeneralAccounts generalAccount = new GeneralAccounts();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByExternalId");
        query.setParameter("external_id", externalId);
        try {
            generalAccount = (GeneralAccounts) query.getSingleResult();
            LOG.log(Level.FINE, "offices found for externalId {0}", new Object[]{externalId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return generalAccount;
    }

    public List<GeneralAccounts> findByHeirarchy(String heirarchy) {
        List<GeneralAccounts> generalAccountList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByHierarchy");
        query.setParameter("hierarchy", heirarchy);
        try {
            generalAccountList = query.getResultList();
            LOG.log(Level.FINE, "offices found for heirarchy {0}", new Object[]{heirarchy});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return generalAccountList;
    }

    public List<GeneralAccounts> findByParentId(String parentId) {
        List<GeneralAccounts> generalAccountList = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("MOffice.findByParentId");
        query.setParameter("parent_id", parentId);
        try {
            generalAccountList = query.getResultList();
            LOG.log(Level.FINE, "offices found for parentId {0}", new Object[]{parentId});
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "unexpected exception {0}\n{1}", new Object[]{ex.getMessage(), Utilities.getStackTrace(ex)});
            return null;
            // don't throw WebApplicationException, force caller to handle this
        } finally {
            LOG.log(Level.FINER, "closing entity manager {0}", em);
            em.close();
        }
        return generalAccountList;
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
