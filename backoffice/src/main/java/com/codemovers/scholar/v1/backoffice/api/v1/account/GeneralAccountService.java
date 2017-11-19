/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.account;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.account.entities.Account;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;

/**
 *
 * @author mover 11/18/2017
 */
public class GeneralAccountService extends AbstractService<Account> {

    private GeneralAccounts accounts = null;

    public GeneralAccountService() {
        if (accounts == null) {
            accounts = new GeneralAccounts();
        }
    }

    @Override
    public Account create(Account entity) {

        //todo : create a general account
        //todo: create a user
        //todo:: assign user role
        return entity;
    }
    
}
