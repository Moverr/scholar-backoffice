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
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mover 11/24/2017
 */
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
            return service.create(authentication, entity);
        } catch (Exception ex) {
            Logger.getLogger(SchoolAccountsEndpoint.class.getName()).log(Level.SEVERE, null, ex);

            throw ex;
        }

    }

    @Override
    public SchoolaAccountResponse update(Integer id, _SchoolAccount entity) {
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
    public Collection<SchoolaAccountResponse> list(int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
