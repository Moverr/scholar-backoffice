/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users;

import com.amazonaws.services.identitymanagement.model.Role;
import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.GeneralAccountService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.UserRole;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author MOver 11/19/2017
 */
public class UserService extends AbstractService<_User> {

    private final UserJpaController controller;

    private static UserService service = null;

    public UserService() {
        controller = UserJpaController.getInstance();
    }

    public static UserService getInstance() {
        if (service == null) {
            service = new UserService();
        }
        return service;
    }

    @Override
    public _User create(_User entity) throws Exception {
        // Validate Mandatories 
        entity.validateMandatory();

        Users user = new Users();

        // get General Account by Id 
        GeneralAccounts account = GeneralAccountService.getInstance().getGneralAccountById(entity.getAccount_id());

        user.setAccount(account);
        user.setPassword(entity.getPassword());
        user.setUsername(entity.getUsername());
        StatusEnum statusEnum = StatusEnum.fromString(entity.getStatus());

        Role _role = new Role();
        user.addRole(_role);
        // UserRole role        // todo :  crerate new user and return user ::
        Users users = controller.create(user);

        return populateResponse(users);

    }

    private _User populateResponse(Users users) throws Exception {

        _User user = new _User();
        user.setId(users.getId().intValue());
        user.setAccount_id(users.getAccount().getId().intValue());
        user.setUsername(users.getUsername());
        user.setStatus(users.getStatus());
        user.setDatecreated(users.getDateCreated());
        return user;
    }

    @Override
    public _User getById(Integer Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
