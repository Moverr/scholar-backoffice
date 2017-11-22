/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities.AuthenticationResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._Account;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._login;
import com.codemovers.scholar.v1.backoffice.api.v1.users.UserService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.GeneralAccountJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Person;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import static com.codemovers.scholar.v1.backoffice.helper.Utilities.getNewExternalId;
import com.codemovers.scholar.v1.backoffice.helper.enums.AccountType;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.BadRequestException;

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
    public _Account create(_Account entity) throws Exception {

        try {
            //todo: person
            Person person = null;

            //todo : create a general account
            accounts = new GeneralAccounts();
            accounts.setExternalid(getNewExternalId());

            accounts.setAccountType(entity.getAccounttype().toString());

            //accounts.setStatus(entity.getStatus().toString());
            accounts.setStatus("ACTIVE");

            accounts.setDateCreated(new Date());

            //todo: create General AcFcount ::
            GeneralAccounts account = controller.create(accounts);
            //todo: create a user
            _User user = new _User();
            user.setAccount_id(account.getId().intValue());

            user.setUsername(entity.getUsername());
            user.setPassword(entity.getPassword());
            user.setStatus(StatusEnum.ACTIVE.toString());

            if (accounts.getAccountType() != null) {
                switch (accounts.getAccountType()) {

                    case "NORMAL":
                        user.setRole("ADMIN");
                        break;

                    case "COMPANY":
                        user.setRole("ADMIN");
                        break;

                    case "ORGANISATION":
                        user.setRole("ADMIN");
                        break;


                    default:
                        user.setRole("ADMIN");
                        break;
                }

            }

//         
//            if (accounts.getAccountType().equalsIgnoreCase("")) {
//
//            }

            user = UserService.getInstance().create(user);
            List<Users> users_ = new ArrayList<>();
//            users_.add(user);
        //    account.setUsersCollection(users_);

            //todo:: assign user roleF
            return entity;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public _Account getById(Integer Id) throws Exception {
        GeneralAccounts account = controller.findAccount(Id);

        _Account a = new _Account();
        a.setId(account.getId().intValue());
        a.setExternalid(account.getExternalid());
        a.setAccounttype(AccountType.fromString(account.getAccountType()));

        return a;

    }

    public GeneralAccounts getGneralAccountById(Integer Id) throws Exception {
        GeneralAccounts account = controller.findAccount(Id);
        return account;

    }

    public AuthenticationResponse login(_login login, String logId) throws Exception {

        String Authentication = null;

        {
            if (login.getPassword() != null && login.getUsername() != null) {
                // todo : encrypt password
                  Authentication = UserService.getInstance().login(login.getUsername(), login.getPassword(), logId);

                if (Authentication == null) {
                    throw new BadRequestException("INVALID USERNAME AND OR PASSWORD ");
                } else {
                    // create response :: 
                }
                //todo : check username and password
            } else {
                throw new BadRequestException(" USERNAME AND OR PASSWORD IS MANDATORY  ");
            }

        }

        return null;
        //todo: 
    }


}
