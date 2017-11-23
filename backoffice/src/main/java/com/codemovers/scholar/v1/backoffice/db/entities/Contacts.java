/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mover
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c")
    , @NamedQuery(name = "Contacts.findById", query = "SELECT c FROM Contacts c WHERE c.id = :id")
    , @NamedQuery(name = "Contacts.findByParentType", query = "SELECT c FROM Contacts c WHERE c.parentType = :parentType")
    , @NamedQuery(name = "Contacts.findByParentId", query = "SELECT c FROM Contacts c WHERE c.parentId = :parentId")
    , @NamedQuery(name = "Contacts.findByContactType", query = "SELECT c FROM Contacts c WHERE c.contactType = :contactType")
    , @NamedQuery(name = "Contacts.findByDetails", query = "SELECT c FROM Contacts c WHERE c.details = :details")
    , @NamedQuery(name = "Contacts.findByStatus", query = "SELECT c FROM Contacts c WHERE c.status = :status")
    , @NamedQuery(name = "Contacts.findByParentTypeANDId", query = "SELECT c FROM Contacts c WHERE c.parentType = :parentType AND c.parentId = :parentId ")

})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "parent_type")
    private String parentType;
    @Column(name = "parent_id")
    private Integer parentId;
    @Size(max = 255)
    @Column(name = "contact_type")
    private String contactType;
    @Size(max = 255)
    @Column(name = "details")
    private String details;
    @Size(max = 8)
    @Column(name = "status")
    private String status;

    public Contacts() {
    }

    public Contacts(Integer id) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{"
                + "id=" + id
                + ", parentType=" + parentType
                + ", parentId=" + parentId
                + ", contactType=" + contactType
                + ", details=" + details
                + ", status=" + status
                + "}";
    }

}
