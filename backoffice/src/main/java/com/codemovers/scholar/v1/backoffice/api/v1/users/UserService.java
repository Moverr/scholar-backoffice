/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;

/**
 *
 * @author MOver 11/19/2017
 */
public class UserService extends AbstractService<_User> {

    @Override
    public _User create(_User entity) {

        return entity;

    }

}
