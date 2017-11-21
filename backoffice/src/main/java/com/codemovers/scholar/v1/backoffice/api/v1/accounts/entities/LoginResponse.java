package com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author podolak
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    private String authentication;
    private String token;
    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public LoginResponse(String authentication, String token, String tenantId) {
        this.authentication = authentication;
        this.token = token;
        this.tenantId = tenantId;
    }

    public LoginResponse(String authentication, String token) {
        this.authentication = authentication;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }

    public LoginResponse(String authentication) {
        this.authentication = authentication;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

}
