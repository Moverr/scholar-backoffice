/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.roles;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.roles.entities._Role;
import com.codemovers.scholar.v1.backoffice.api.v1.users.UserService;
import com.codemovers.scholar.v1.backoffice.db.controllers.RoleJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.Roles;

/**
 *
 * @author Manny
 */
public class RolesService extends AbstractService<_Role> {

    private final RoleJpaController controller;

    private static RolesService service = null;

    public RolesService() {
        controller = RoleJpaController.getInstance();
    }

    public static RolesService getInstance() {
        if (service == null) {
            service = new RolesService();
        }
        return service;
    }


    @Override
    public _Role create(_Role entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public _Role getById(Integer Id) throws Exception {
        controller.find(Id);

        return null;
    }

    public List<Roles> getRoleByName(String name) throws Exception {

        return controller.findByName(name);

    }

}
