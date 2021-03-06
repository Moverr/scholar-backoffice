/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.roles.RolesService;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities.UserResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.users.entities._User;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserJpaController;
import com.codemovers.scholar.v1.backoffice.db.controllers.UserRoleJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts;
import com.codemovers.scholar.v1.backoffice.db.entities.Roles;
import com.codemovers.scholar.v1.backoffice.db.entities.UserRole;
import com.codemovers.scholar.v1.backoffice.db.entities.Users;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import com.codemovers.scholar.v1.backoffice.helper.exceptions.BadRequestException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.sonatype.plexus.components.cipher.Base64;

/**
 *
 * @author MOver 11/19/2017
 */
public class UserService extends AbstractService<_User, UserResponse> {

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
    public UserResponse create(_User entity) throws Exception {
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

        // Get the User Response 
        Users u = controller.findUser(users.getId());

        LOG.log(Level.INFO, "USER RESPONSE {0} ", u.toString());

        //        LOG.log(Level.INFO, "USER RESPONSE {0} ", userRole.toString());

        return populateResponse(u);

    }


    private UserResponse populateResponse(Users users) throws Exception {

        UserResponse response = new UserResponse();
        response.setId(users.getId());
        response.setAccountId(users.getAccount().getId());
        response.setUsername(users.getUsername());
        response.setStatus(users.getStatus());
        response.setDateCreated(users.getDateCreated());

        return response;
    }

    //todo: retrieve authentication 
    public Users login(String username, String password, String logid) throws Exception {

        LOG.log(Level.INFO, " USERSERVICE Account Service Login {0} ", username);

        String authentication = null;

        String encryptedPassword = Utilities.encryptPassword_md5(password);
        Users user = controller.login(username, encryptedPassword);

        return user;

    }

    @Override
    public UserResponse getById(Integer Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String convertToBasicAuth(String username, String Password) {
        String authString = username + ":" + Password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        return ("Basic:" + authStringEnc);
        //  String possibleAuthenticationKey = "Basic " + Base64.getEncoder().encodeToString(usernamePassowrd.trim().getBytes());

    }

    //todo: validate authenticaton
    public boolean validateAuthentication(String authentication) throws Exception {
        try {
            Users user = null;
            authentication = authentication.replace("Basic:", "");

            LOG.log(Level.INFO, "AUTHENTICATION {0}  ", authentication);

            String usernamePassword = new String(java.util.Base64.getDecoder().decode(authentication));
            String[] parts = usernamePassword.split(":");

            if (parts.length != 2) {
                LOG.log(Level.WARNING, "{0} :: invalid security credentials");
                throw new WebApplicationException("invalid security credentials", Response.Status.UNAUTHORIZED);
            }

            String username = parts[0];
            String password = parts[1];
            user = login(username, password, "LOGID");

        if (user == null) {
            throw new BadRequestException(" invalid security credentials ", Response.Status.UNAUTHORIZED.toString());

            }
        } catch (Exception er) {
            LOG.log(Level.WARNING, " VALIDATE TOKEN  ERROR  {0} ", er.toString());
            throw er;
        }


        return true;
    }

}
