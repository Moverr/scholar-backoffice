/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._Account;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.GeneralAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Person;
import static com.codemovers.scholar.v1.backoffice.helper.Utilities.getNewExternalId;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;

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

        try {
            //todo: person
            Person person = null;

            //todo : create a general account
            accounts = new GeneralAccounts();
            accounts.setExternalid(getNewExternalId());

            accounts.setAccountType(entity.getAccounttype().toString());
            accounts.setStatus(entity.getStatus().toString());

            //todo: create General AcFcount ::
            GeneralAccounts account = controller.create(accounts);
            //todo: create a user
            _User user = new _User();
            user.setAccount_id(account.getId().intValue());

            user.setUsername(entity.getUsername());
            user.setPassword(entity.getPassword());
            user.setStatus(StatusEnum.ACTIVE.toString());

            //todo:: assign user roleF
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public _Account getById(Integer Id) {
        GeneralAccounts account = controller.find(Id);

        return null;

    }

}
