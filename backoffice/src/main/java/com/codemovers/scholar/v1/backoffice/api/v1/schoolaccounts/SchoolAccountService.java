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
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
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
       boolean validation_status = entity.validate();

        if (validation_status == false) {
            throw new BadRequestException("VALIDATE MANDATORIES ");
        }

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
        schoolAccount.setExternalId(Utilities.getNewExternalId());
        schoolAccount.setName(entity.getName());

        schoolAccount = controller.create(schoolAccount);

        return populateResponse(schoolAccount);


    }

    @Override
    public SchoolaAccountResponse getById(String authentication, Integer Id) throws Exception {
        boolean status = UserService.getInstance().validateAuthentication(authentication);

        if (status == false) {
            throw new BadRequestException("INVALID AUTHENTICATION CREDENTIALS ");
        }

        SchoolAccount schoolAccount = controller.findById(Id);
        return populateResponse(schoolAccount);
    }

    public SchoolAccount getSchoolAccountbyId(String authentication, Integer Id) throws Exception {

        boolean status = UserService.getInstance().validateAuthentication(authentication);

        if (status == false) {
            throw new BadRequestException("INVALID AUTHENTICATION CREDENTIALS ");
        }

        SchoolAccount schoolAccount = controller.findById(Id);

        return schoolAccount;
    }


    public SchoolaAccountResponse populateResponse(SchoolAccount schoolAccount) {

        if (schoolAccount == null) {
            return null;
        }

        SchoolaAccountResponse accountResponse = new SchoolaAccountResponse();

        if (schoolAccount.getGeneral_account() != null) {
            accountResponse.setAccount_id(schoolAccount.getGeneral_account().getId());
        }

        accountResponse.setCreated_date(schoolAccount.getCreatedDate());
        accountResponse.setJoin_date(schoolAccount.getJoinDate());
        accountResponse.setExternal_id(schoolAccount.getExternalId());
        accountResponse.setName(schoolAccount.getName());
        accountResponse.setTimezone_code(schoolAccount.getTimezoneCode());

        accountResponse.setLast_modified(schoolAccount.getLastModified());
        accountResponse.setId(schoolAccount.getId());

        return accountResponse;
    }

}
