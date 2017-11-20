/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;

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
    public _User create(_User entity) {
        // Validate Mandatories 
        entity.validateMandatory();

        Users user = new Users();
        GeneralAccounts account = new GeneralAccounts(entity.getAccount_id().longValue());
        user.setAccount(account);
        user.setPassword(entity.getPassword());
        user.setUsername(entity.getUsername());
        StatusEnum statusEnum = StatusEnum.fromString(entity.getStatus());

        // todo :  crerate new user and return user ::
        Users users = controller.create(user);
        return populateResponse(users);

    }

    private _User populateResponse(Users users) {

        _User user = new _User();
        user.setId(users.getId().intValue());
        user.setAccount_id(users.getAccount().getId().intValue());
        user.setUsername(users.getUsername());
        user.setStatus(users.getStatus());
        user.setDatecreated(users.getDateCreated());
        return user;
    }

}
