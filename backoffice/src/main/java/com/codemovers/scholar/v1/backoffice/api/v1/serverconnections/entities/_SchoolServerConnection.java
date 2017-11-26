/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities;

import com.codemovers.scholar.v1.backoffice.api.annotation.Mandatory;
import com.codemovers.scholar.v1.backoffice.helper.Utilities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

/**
 *
 * @author Mover 11/26/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class _SchoolServerConnection {

    private Integer id;
    private @Mandatory
    Integer school_account_id;
    private @Mandatory
    String schema_server;

    /*
    the shema name, is created by using the external id of the school_account:
    it means, u create a db using external_id in case of another db :
    concatenate with version :

    //todo ::
     you can not create the same  db on the same server  but you can create on different servers  wheere there is a parent id ::
    
     */
    private    String schema_name;
    private @Mandatory
    String schema_username;
    private @Mandatory
    String schema_password;
    private @Mandatory
    String engine_url;

    private Integer parent_db;

    public _SchoolServerConnection() {
    }

    public _SchoolServerConnection(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchool_account_id() {
        return school_account_id;
    }

    public void setSchool_account_id(Integer school_account_id) {
        this.school_account_id = school_account_id;
    }

    public String getSchema_server() {
        return schema_server;
    }

    public void setSchema_server(String schema_server) {
        this.schema_server = schema_server;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public void setSchema_name(String schema_name) {
        this.schema_name = schema_name;
    }

    public String getSchema_username() {
        return schema_username;
    }

    public void setSchema_username(String schema_username) {
        this.schema_username = schema_username;
    }

    public String getSchema_password() {
        return schema_password;
    }

    public void setSchema_password(String schema_password) {
        this.schema_password = schema_password;
    }

    public Integer getParent_db() {
        return parent_db;
    }

    public void setParent_db(Integer parent_db) {
        this.parent_db = parent_db;
    }

    public String getEngine_url() {
        return engine_url;
    }

    public void setEngine_url(String engine_url) {
        this.engine_url = engine_url;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.school_account_id);
        hash = 41 * hash + Objects.hashCode(this.schema_server);
        hash = 41 * hash + Objects.hashCode(this.schema_name);
        hash = 41 * hash + Objects.hashCode(this.schema_username);
        hash = 41 * hash + Objects.hashCode(this.schema_password);
        hash = 41 * hash + Objects.hashCode(this.parent_db);
        hash = 41 * hash + Objects.hashCode(this.engine_url);
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
        final _SchoolServerConnection other = (_SchoolServerConnection) obj;
        if (!Objects.equals(this.schema_server, other.schema_server)) {
            return false;
        }
        if (!Objects.equals(this.schema_name, other.schema_name)) {
            return false;
        }
        if (!Objects.equals(this.schema_username, other.schema_username)) {
            return false;
        }
        if (!Objects.equals(this.schema_password, other.schema_password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.school_account_id, other.school_account_id)) {
            return false;
        }
        if (!Objects.equals(this.engine_url, other.engine_url)) {
            return false;
        }

        return Objects.equals(this.parent_db, other.parent_db);
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
        return "_SchoolServerConnection{"
                + "id=" + id
                + ", school_account_id=" + school_account_id
                + ", schema_server=" + schema_server
                + ", schema_name=" + schema_name
                + ", schema_username=" + schema_username
                + ", schema_password=" + schema_password
                + ", parent_db=" + parent_db
                + ", engine_url=" + engine_url
                + "}";
    }

}
