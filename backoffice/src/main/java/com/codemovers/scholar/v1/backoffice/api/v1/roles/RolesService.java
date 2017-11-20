/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.roles;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractEndpoint;
import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.roles.entities._Role;
import com.codemovers.scholar.v1.backoffice.db.controllers.RoleJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.Roles;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manny
 */
public class RolesService extends AbstractService<_Role> {
    private static final Logger LOG = Logger.getLogger(RolesService.class.getName());

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

    public Roles getRoleByName(String name) throws Exception {

        Roles r = null;
        try {
            List<Roles> list = controller.findByName(name);
            if (list != null) {
                r = list.get(0);
            }
        } catch (Exception er) {
            LOG.log(Level.INFO, er.toString());
            throw er;
        }

        return r;
    }

}
