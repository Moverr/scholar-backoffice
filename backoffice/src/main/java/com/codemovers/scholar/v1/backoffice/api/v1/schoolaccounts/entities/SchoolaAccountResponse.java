/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.schoolaccounts.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mover 11/24/2017
 */
public class SchoolaAccountResponse {

    private Integer id;
    private Integer account_id;
    private String name;
    private String timezone_code;
    private Date join_date;
    private Date created_date;
    private Date last_modified;
    private String external_id;

    public SchoolaAccountResponse() {
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

    public String getTimezone_code() {
        return timezone_code;
    }

    public void setTimezone_code(String timezone_code) {
        this.timezone_code = timezone_code;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
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
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.account_id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.timezone_code);
        hash = 79 * hash + Objects.hashCode(this.join_date);
        hash = 79 * hash + Objects.hashCode(this.created_date);
        hash = 79 * hash + Objects.hashCode(this.last_modified);
        hash = 79 * hash + Objects.hashCode(this.external_id);
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
        final SchoolaAccountResponse other = (SchoolaAccountResponse) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.timezone_code, other.timezone_code)) {
            return false;
        }
        if (!Objects.equals(this.external_id, other.external_id)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.account_id, other.account_id)) {
            return false;
        }
        if (!Objects.equals(this.join_date, other.join_date)) {
            return false;
        }
        if (!Objects.equals(this.created_date, other.created_date)) {
            return false;
        }
        return Objects.equals(this.last_modified, other.last_modified);
    }

    @Override
    public String toString() {
        return "SchoolAccount{"
                + "id=" + id
                + ", account_id=" + account_id
                + ", name=" + name
                + ", timezone_code=" + timezone_code
                + ", join_date=" + join_date
                + ", created_date=" + created_date
                + ", last_modified=" + last_modified
                + ", external_id=" + external_id
                + "}";
    }



}
