/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.abstracts;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mover 11/15/2017
 */
public abstract class AbstractEndpoint<T> {

    private final Class<T> AbstractEndpoint;

    public AbstractEndpoint(Class<T> AbstractEndpoint) {
        this.AbstractEndpoint = AbstractEndpoint;
    }

    public abstract T create(T entity);

    public abstract T update(T entity);

    public abstract T archive(@PathParam("id") Integer id);

    public abstract void delete(@PathParam("id") Integer id);

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public abstract T[] list(
            @DefaultValue("0") @PathParam("offset") Integer start,
            @DefaultValue("50") @PathParam("limit") Integer end
    );

    /**
     *
     * @param id
     * @return
     */
    public abstract T getItem(
            @PathParam("id") Integer id
    );





}
