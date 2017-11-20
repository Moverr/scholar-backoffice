/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.controllers;

import com.codemovers.scholar.v1.backoffice.db.JpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

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



}
