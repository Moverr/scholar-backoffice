/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractEndpoint;
import com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities.SchoolaAccountResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities._SchoolAccount;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Mover 11/24/2017
 */
@Path("/")
public class SchoolAccountsEndpoint extends AbstractEndpoint<_SchoolAccount, SchoolaAccountResponse> {

    private static final Logger LOG = Logger.getLogger(SchoolAccountsEndpoint.class.getName());
    @Context
    private ContainerRequestContext context;

    private SchoolAccountService service = null;

    public SchoolAccountsEndpoint() {
        service = SchoolAccountService.getInstance();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public SchoolaAccountResponse create(@HeaderParam("authentication") String authentication, _SchoolAccount entity) throws Exception {

        try {
            LOG.log(Level.INFO, "REACHED THE TENANT");
            return service.create(authentication, entity);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "CAN NOT CREATE SCHOOL ACCOUNT SUCCESFULLY {0}",
                    ex.getMessage()
            );
            throw ex;
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    @Override
    public SchoolaAccountResponse update(@PathParam("id") Integer id, _SchoolAccount entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("archive/{id}")
    @Override
    public Response archive(@PathParam("id") Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Path("list/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<SchoolaAccountResponse> list(@QueryParam("start") @DefaultValue("0") int start, @QueryParam("end") @DefaultValue("50") int end) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
