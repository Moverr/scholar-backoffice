/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.serverconnections;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.SchoolAccountService;
import com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities.SchoolServerConnectionResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities._SchoolServerConnection;
import com.codemovers.scholar.v1.backoffice.api.v1.users.UserService;
import com.codemovers.scholar.v1.backoffice.db.controllers.SchoolServerConnectionJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.SchoolAccount;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author Mover 11/26/2017
 */
public class SchoolServerConnectionService extends AbstractService<_SchoolServerConnection, SchoolServerConnectionResponse> {

    private static final Logger LOG = Logger.getLogger(SchoolServerConnectionService.class.getName());

    private static SchoolServerConnectionService service = null;

    GeneralAccounts general_account = null;
    private final SchoolServerConnectionJpaController controller;

    public SchoolServerConnectionService() {
        controller = new SchoolServerConnectionJpaController();
    }

    public static SchoolServerConnectionService getInstance() {
        if (service == null) {
            service = new SchoolServerConnectionService();
        }
        return service;
    }

    @Override
    public SchoolServerConnectionResponse create(String authentication, _SchoolServerConnection entity) throws Exception {

        //todo: verify login:
        boolean status = UserService.getInstance().validateAuthentication(authentication);

        if (status == false) {
            throw new BadRequestException("INVALID AUTHENTICATION CREDENTIALS ");
        }

        boolean validation_status = entity.validate();

        if (validation_status == false) {
            throw new BadRequestException("VALIDATE MANDATORIES ");
        }
        SchoolAccount schoolAccount = SchoolAccountService.getInstance().getSchoolAccountbyId(authentication, entity.getSchool_account_id());

        return null;
    }

    @Override
    public SchoolServerConnectionResponse getById(String authentication, Integer Id) throws Exception {
        return super.getById(authentication, Id); //To change body of generated methods, choose Tools | Templates.
    }


}
