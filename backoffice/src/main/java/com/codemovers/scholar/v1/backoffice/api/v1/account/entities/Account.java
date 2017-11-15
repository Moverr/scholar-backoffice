/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.account.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
 *
 * @author MOVER 11/15/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    private String ACCOUNTTYPE;
    //THIS CAN BE AN EMAIL
    private String USERNAME;
    private string PASSWORD;
    private String EMAILADDRESS;

    //
    private String ACCOUNTID;

    public Account() {
    }

    public String getACCOUNTTYPE() {
        return ACCOUNTTYPE;
    }

    public void setACCOUNTTYPE(String ACCOUNTTYPE) {
        this.ACCOUNTTYPE = ACCOUNTTYPE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public string getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(string PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getEMAILADDRESS() {
        return EMAILADDRESS;
    }

    public void setEMAILADDRESS(String EMAILADDRESS) {
        this.EMAILADDRESS = EMAILADDRESS;
    }

    public String getACCOUNTID() {
        return ACCOUNTID;
    }

    public void setACCOUNTID(String ACCOUNTID) {
        this.ACCOUNTID = ACCOUNTID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ACCOUNTTYPE);
        hash = 79 * hash + Objects.hashCode(this.USERNAME);
        hash = 79 * hash + Objects.hashCode(this.PASSWORD);
        hash = 79 * hash + Objects.hashCode(this.EMAILADDRESS);
        hash = 79 * hash + Objects.hashCode(this.ACCOUNTID);
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
        if (!Objects.equals(this.ACCOUNTTYPE, other.ACCOUNTTYPE)) {
            return false;
        }
        if (!Objects.equals(this.USERNAME, other.USERNAME)) {
            return false;
        }
        if (!Objects.equals(this.EMAILADDRESS, other.EMAILADDRESS)) {
            return false;
        }
        if (!Objects.equals(this.ACCOUNTID, other.ACCOUNTID)) {
            return false;
        }
        return Objects.equals(this.PASSWORD, other.PASSWORD);
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{"
                + "ACCOUNTTYPE=" + ACCOUNTTYPE
                + ", USERNAME=" + USERNAME
                + ", PASSWORD=" + PASSWORD
                + ", EMAILADDRESS=" + EMAILADDRESS
                + ", ACCOUNTID=" + ACCOUNTID
                + "}";
    }


}
