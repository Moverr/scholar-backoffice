/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.GeneralAccountService;
import com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities.SchoolaAccountResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities._SchoolAccount;
import com.codemovers.scholar.v1.backoffice.api.v1.users.UserService;
import com.codemovers.scholar.v1.backoffice.db.controllers.GeneralAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.SchoolAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.SchoolAccount;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import java.util.Date;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author Mover 11/24/2017
 */
public class SchoolAccountService extends AbstractService<_SchoolAccount, SchoolaAccountResponse> {
    private static final Logger LOG = Logger.getLogger(SchoolAccountService.class.getName());

    private static SchoolAccountService service = null;

    GeneralAccounts general_account = null;
    private final SchoolAccountJpaController controller;

    public SchoolAccountService() {
        controller = new SchoolAccountJpaController();
    }

    public static SchoolAccountService getInstance() {
        if (service == null) {
            service = new SchoolAccountService();
        }
        return service;
    }

    @Override
    public SchoolaAccountResponse create(String authentication, _SchoolAccount entity) throws Exception {

        //todo: verify login:
        boolean status = UserService.getInstance().validateAuthentication(authentication);

        if (status == false) {
            throw new BadRequestException("INVALID AUTHENTICATION CREDENTIALS ");
        }
        //todo: create school account

        // get the General Account associated with the school
       general_account = GeneralAccountService.getInstance().getGneralAccountById(entity.getAccount_id());

        if (general_account == null) {
            throw new BadRequestException(" GENERAL ACCOUNT DOES NOT EXIST ");
        }

        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setCreatedDate(new Date());
        schoolAccount.setGeneral_account(general_account);
        schoolAccount.setTimezoneCode(entity.getTime_zone());
        schoolAccount.setJoinDate(entity.getJoin_date());

        schoolAccount = controller.create(schoolAccount);


        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public SchoolaAccountResponse getById(String Authentication, Integer Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
