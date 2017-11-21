/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractEndpoint;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities.LoginResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._Account;
import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities._login;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mover 11/15/2017
 */
@Path("/")
public class GeneralAccountsEndpoint extends AbstractEndpoint<_Account> {
    private static final Logger LOG = Logger.getLogger(AbstractEndpoint.class.getName());

    @Context
    private ContainerRequestContext context;

    GeneralAccountService service;

    public GeneralAccountsEndpoint() {
        service = new GeneralAccountService();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public _Account create(_Account entity) {

        try {
            LOG.log(Level.INFO, "Create General Account Endpoint ");

            entity = service.create(entity);
            //todo: assign role to connector ::
            return entity;
        } catch (Exception ex) {
            Logger.getLogger(GeneralAccountsEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            throw new BadRequestException("Something Went Wrong ");
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    @Override
    public _Account update(@PathParam("id") Integer id, _Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("archive/{id}")
    public Response archive(@PathParam("id") Integer id) {
        return null;
    }

    @Override
    @Path("delete/")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        return null;
    }

    @Override
    @Path("list/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public _Account list(@QueryParam("start") @DefaultValue("0") int start, @QueryParam("end") @DefaultValue("50") int end) {

        LOG.log(Level.INFO, "INSIDE THE DAMN ");
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Path("login/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(
            _login login,
            @Context HttpServletRequest httpRequest
    ) {
        String logId = context.getProperty("logId").toString();

        Utilities.logHttpServletRequest(httpRequest, logId);
        LOG.log(Level.INFO, "{0} :: start", new Object[]{logId});

        service.login(login, logId);

        return null;
    }


}
