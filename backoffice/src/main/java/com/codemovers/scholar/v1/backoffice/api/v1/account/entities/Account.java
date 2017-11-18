/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.account.entities;

import com.codemovers.scholar.v1.backoffice.helper.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
 *
 * @author MOVER 11/15/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    private AccountType accounttype;
    //THIS CAN BE AN EMAIL
    private String username;
    private String password;
    private String emailaddress;
    private String accountid;

    public Account() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.accounttype);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.emailaddress);
        hash = 53 * hash + Objects.hashCode(this.accountid);
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
        final Account other = (Account) obj;
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
                + "}";
    }


}
