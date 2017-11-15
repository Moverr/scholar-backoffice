/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.abstracts;

/**
 *
 * @author mover 11/15/2017
 */
public abstract class AbstractEndpoint<T> {

    private final Class<T> AbstractEndpoint;

    public AbstractEndpoint(Class<T> AbstractEndpoint) {
        this.AbstractEndpoint = AbstractEndpoint;
    }

    public abstract Class<T> create(T entity);

    public abstract Class<T> update(T entity);

    public abstract Class<T> archive(T entity);

    public abstract Class<T> delete(T entity);




}
