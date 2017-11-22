/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.abstracts;

import java.util.Collection;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author mover 11/15/2017
 */
public abstract class AbstractEndpoint<T, Z> {

    public abstract Z create(T entity);

    /**
     *
     * @param id
     * @return
     */
    public abstract Z update(@PathParam("id") Integer id, T entity);

    public abstract Response archive(@PathParam("id") Integer id);

    public abstract Response delete(@PathParam("id") Integer id);

    public abstract Collection<Z> list(@QueryParam("start") int start, @QueryParam("end") int end);




}
