/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities;

import com.codemovers.scholar.v1.backoffice.api.annotation.Mandatory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author mover
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _login {
    private @Mandatory
    String username;
    private @Mandatory
    String password;

    public _login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
