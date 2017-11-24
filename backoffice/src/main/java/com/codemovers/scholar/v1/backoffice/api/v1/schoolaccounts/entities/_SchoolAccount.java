/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities;

import com.codemovers.scholar.v1.backoffice.api.annotation.Mandatory;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mover 11/24/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _SchoolAccount {

    private Integer id;
    private @Mandatory
    Integer account_id;
    private @Mandatory
    String name;
    private @Mandatory
    String time_zone;
    private @Mandatory
    Date join_date;
    private String external_id;

    public _SchoolAccount() {
    }

    public _SchoolAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.account_id);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.time_zone);
        hash = 37 * hash + Objects.hashCode(this.join_date);
        hash = 37 * hash + Objects.hashCode(this.external_id);
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
        final _SchoolAccount other = (_SchoolAccount) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.time_zone, other.time_zone)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.account_id, other.account_id)) {
            return false;
        }
        return Objects.equals(this.join_date, other.join_date);
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
        return "_SchoolAccount{"
                + "id=" + id
                + ", account_id=" + account_id
                + ", name=" + name
                + ", time_zone=" + time_zone
                + ", join_date=" + join_date
                + ", external_id=" + external_id
                + "}";
    }



}
