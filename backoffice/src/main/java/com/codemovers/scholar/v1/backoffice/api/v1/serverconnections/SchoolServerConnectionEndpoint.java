/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.serverconnections;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractEndpoint;
import com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities.SchoolServerConnectionResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities._SchoolServerConnection;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mover 11/26/2017
 */
@Path("/")
public class SchoolServerConnectionEndpoint extends AbstractEndpoint<_SchoolServerConnection, SchoolServerConnectionResponse> {

    private static final Logger LOG = Logger.getLogger(SchoolServerConnectionEndpoint.class.getName());
    @Context
    private ContainerRequestContext context;

    private SchoolServerConnectionService service = null;

    public SchoolServerConnectionEndpoint() {
        service = SchoolServerConnectionService.getInstance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public SchoolServerConnectionResponse create(@HeaderParam("authentication") String authentication, _SchoolServerConnection entity) throws Exception {

        try {
            LOG.log(Level.INFO, "REACHED THE TENANT");
            return service.create(authentication, entity);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "CAN NOT CREATE SCHOOL SERVER CONNECTION  SUCCESFULLY {0}",
                    ex.getMessage()
            );
            throw ex;
        }

    }


    @Override
    public SchoolServerConnectionResponse update(Integer id, _SchoolServerConnection entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response archive(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<SchoolServerConnectionResponse> list(int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
