/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.serverconnections.entities;

import java.util.Objects;

/**
 *
 * @author Mover 11/26/2017
 */
public class SchoolServerConnectionResponse {
    private Integer id;
    private Integer school_account_id;
    private String schema_server;
    private String schema_name;
    private String schema_username;
    private String schema_password;
    private String engine_url;
    private Integer parent_db;

    public SchoolServerConnectionResponse() {
    }

    public SchoolServerConnectionResponse(Integer id) {
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
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.school_account_id);
        hash = 29 * hash + Objects.hashCode(this.schema_server);
        hash = 29 * hash + Objects.hashCode(this.schema_name);
        hash = 29 * hash + Objects.hashCode(this.schema_username);
        hash = 29 * hash + Objects.hashCode(this.schema_password);
        hash = 29 * hash + Objects.hashCode(this.parent_db);
        hash = 29 * hash + Objects.hashCode(this.engine_url);
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
        final SchoolServerConnectionResponse other = (SchoolServerConnectionResponse) obj;
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

    @Override
    public String toString() {
        return "SchoolServerConnectionResponse{"
                + "id=" + id
                + ", school_account_id=" + school_account_id
                + ", schema_server=" + schema_server
                + ", schema_name=" + schema_name
                + ", schema_username=" + schema_username
                + ", schema_password=" + schema_password
                + ", engine_url=" + engine_url
                + ", parent_db=" + parent_db + '}';
    }


}
