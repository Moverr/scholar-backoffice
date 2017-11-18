/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.abstracts;

/**
 *
 * @author Mover
 */
public abstract class AbstractService<T> {

    public abstract T create(T entity);
}
