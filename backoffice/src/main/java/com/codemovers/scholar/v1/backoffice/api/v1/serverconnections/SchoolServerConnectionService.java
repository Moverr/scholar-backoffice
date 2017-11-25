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
import com.codemovers.scholar.v1.backoffice.db.controllers.SchoolAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.SchoolServerConnectionJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import java.util.logging.Logger;

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

}
