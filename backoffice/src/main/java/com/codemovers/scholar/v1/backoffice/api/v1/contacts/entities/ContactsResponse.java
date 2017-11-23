/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.contacts.entities;

import java.util.Objects;

/**
 *
 * @author Mover 11/23/2017
 */
public class ContactsResponse {

    private Integer id;
    private String parentType;
    private Integer parentId;
    private String contactType;
    private String details;
    private String status;

    public ContactsResponse() {
    }

    public ContactsResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.parentType);
        hash = 71 * hash + Objects.hashCode(this.parentId);
        hash = 71 * hash + Objects.hashCode(this.contactType);
        hash = 71 * hash + Objects.hashCode(this.details);
        hash = 71 * hash + Objects.hashCode(this.status);
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
        final ContactsResponse other = (ContactsResponse) obj;
        if (!Objects.equals(this.parentType, other.parentType)) {
            return false;
        }
        if (!Objects.equals(this.contactType, other.contactType)) {
            return false;
        }
        if (!Objects.equals(this.details, other.details)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.parentId, other.parentId);
    }

    @Override
    public String toString() {
        return "ContactsResponse{"
                + "id=" + id
                + ", parentType=" + parentType
                + ", parentId=" + parentId
                + ", contactType=" + contactType
                + ", details=" + details
                + ", status=" + status
                + "}";
    }


}
