/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._Account;
import com.codemovers.scholar.v1.backoffice.api.v1.users.UserService;
import com.codemovers.scholar.v1.backoffice.db.controllers.GeneralAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Person;

/**
 *
 * @author mover 11/18/2017
 */
public class GeneralAccountService extends AbstractService<_Account> {

    private final GeneralAccountJpaController controller;
    private GeneralAccounts accounts = null;
    private static GeneralAccountService service = null;

    public GeneralAccountService() {
        controller = GeneralAccountJpaController.getInstance();
    }

    public static GeneralAccountService getInstance() {
        if (service == null) {
            service = new GeneralAccountService();
        }
        return service;
    }


    @Override
    public _Account create(_Account entity) {

        //todo: person
        Person person = null;

        //todo : create a general account
        //todo: create a user
        //todo:: assign user role
        return entity;
    }
    
}
