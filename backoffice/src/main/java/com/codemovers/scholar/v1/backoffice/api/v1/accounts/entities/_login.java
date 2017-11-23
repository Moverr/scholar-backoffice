/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities;

import com.codemovers.scholar.v1.backoffice.api.annotation.Mandatory;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final _login other = (_login) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    public boolean validate() {
        try {
            Utilities.validateMandatoryFields(this.getClass(), this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "_login{"
                + "username=" + username
                + ", password=" + password
                + "}";
    }


}
