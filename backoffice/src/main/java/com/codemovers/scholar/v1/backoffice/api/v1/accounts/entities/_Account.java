/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities;

import com.codemovers.scholar.v1.backoffice.helper.enums.AccountType;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
 *
 * @author MOVER 11/15/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _Account {

    private AccountType accounttype;
    //THIS CAN BE AN EMAIL
    private String username;
    private String password;
    private String emailaddress;
    private String accountid;

    private StatusEnum status;
    private String externalid;
    private String date_created;

    public _Account() {
    }

    public AccountType getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(AccountType accounttype) {
        this.accounttype = accounttype;
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getExternalid() {
        return externalid;
    }

    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.accounttype);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.emailaddress);
        hash = 59 * hash + Objects.hashCode(this.accountid);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.externalid);
        hash = 59 * hash + Objects.hashCode(this.date_created);
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
        final _Account other = (_Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.emailaddress, other.emailaddress)) {
            return false;
        }
        if (!Objects.equals(this.accountid, other.accountid)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.externalid, other.externalid)) {
            return false;
        }
        if (!Objects.equals(this.date_created, other.date_created)) {
            return false;
        }
        return this.accounttype == other.accounttype;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{"
                + "accounttype=" + accounttype
                + ", username=" + username
                + ", password=" + password
                + ", emailaddress=" + emailaddress
                + ", accountid=" + accountid
                + ", status=" + status
                + ", externalid=" + externalid
                + ", date_created=" + date_created
                + "}";
    }



}
