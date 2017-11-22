/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.roles.RolesService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserRoleJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Roles;
import com.codemovers.scholar.v1.backoffice.db.entities.UserRole;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import com.codemovers.scholar.v1.backoffice.helper.exceptions.BadRequestException;
import static com.mchange.v2.c3p0.impl.C3P0Defaults.password;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sonatype.plexus.components.cipher.Base64;

/**
 *
 * @author MOver 11/19/2017
 */
public class UserService extends AbstractService<_User> {

    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

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
        GeneralAccounts account = new GeneralAccounts(entity.getAccount_id());

        //GeneralAccountService.getInstance().getGneralAccountById(entity.getAccount_id());
        {
            if (entity.getPassword() == null || entity.getUsername() == null) {
                throw new BadRequestException("USERNAME AND OR PASSWORD IS MANDATORY ");
            }
        }

        user.setAccount(account);
        String password = Utilities.encryptPassword_md5(entity.getPassword());
        user.setPassword(password);
        user.setUsername(entity.getUsername());
        // StatusEnum statusEnum = StatusEnum.fromString(entity.getStatus());
        user.setStatus("ACTIVE");
        user.setDateCreated(new Date());

        Roles _role = RolesService.getInstance().getRoleByName("ADMIN");

        Set<Roles> rs = new HashSet<>();

        rs.add(_role);

        // Set<Roles> rs = new HashMap<Roles>();
        // UserRole role      dsd  // todo :  crerate new user and return user ::
        Users users = controller.create(user);
        LOG.log(Level.INFO, "USER RESPONSE {0} ", users.toString());

        UserRole userRole = new UserRole();
        userRole.setRole(_role);
        userRole.setUser(users);
        UserRoleJpaController.getInstance().create(userRole);

        users.setRoles(rs);


        Users u = controller.findUser(users.getId());

        LOG.log(Level.INFO, "USER RESPONSE {0} ", u.toString());

        //        LOG.log(Level.INFO, "USER RESPONSE {0} ", userRole.toString());

        return populateResponse(u);

    }


    private _User populateResponse(Users users) throws Exception {
        _User user = new _User();
        user.setId(users.getId().intValue());
        user.setAccount_id(users.getAccount().getId());
        user.setUsername(users.getUsername());
        user.setStatus(users.getStatus());
        user.setDatecreated(users.getDateCreated());
        return user;
    }

    //todo: retrieve authentication 
    public String login(String username, String password, String logid) throws Exception {

        String authentication = null;

        String encryptedPassword = Utilities.encryptPassword_md5(password);
        Users user = controller.login(username, encryptedPassword);

        if (user != null) {

            LOG.log(Level.INFO, "USER RESPONSE {0} ", user.toString());

            authentication = convertToBasicAuth(user.getUsername(), user.getPassword());
        }

        return authentication;

    }

    @Override
    public _User getById(Integer Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String convertToBasicAuth(String username, String Password) {
        String authString = username + ":" + Password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        return ("Basic " + authStringEnc);
        //  String possibleAuthenticationKey = "Basic " + Base64.getEncoder().encodeToString(usernamePassowrd.trim().getBytes());

    }

}
