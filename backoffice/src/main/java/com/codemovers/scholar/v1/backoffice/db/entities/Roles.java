/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mover
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id")
    , @NamedQuery(name = "Roles.findByName", query = "SELECT r FROM Roles r WHERE r.name = :name")
    , @NamedQuery(name = "Roles.findByCode", query = "SELECT r FROM Roles r WHERE r.code = :code")
    , @NamedQuery(name = "Roles.findByDescription", query = "SELECT r FROM Roles r WHERE r.description = :description")
    , @NamedQuery(name = "Roles.findByIsSystem", query = "SELECT r FROM Roles r WHERE r.isSystem = :isSystem")
    , @NamedQuery(name = "Roles.findByDateCreated", query = "SELECT r FROM Roles r WHERE r.dateCreated = :dateCreated")
    , @NamedQuery(name = "Roles.findByAuthorId", query = "SELECT r FROM Roles r WHERE r.authorId = :authorId")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 2)
    @Column(name = "isSystem")
    private String isSystem;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "author_id")
    private BigInteger authorId;
    @OneToMany(mappedBy = "role")
    private Collection<UserRole> userRoleCollection;
    @OneToMany(mappedBy = "roleId")
    private Collection<RolePermission> rolePermissionCollection;

    public Roles() {
    }

    public Roles(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public BigInteger getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }

    @XmlTransient
    public Collection<UserRole> getUserRoleCollection() {
        return userRoleCollection;
    }

    public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
        this.userRoleCollection = userRoleCollection;
    }

    @XmlTransient
    public Collection<RolePermission> getRolePermissionCollection() {
        return rolePermissionCollection;
    }

    public void setRolePermissionCollection(Collection<RolePermission> rolePermissionCollection) {
        this.rolePermissionCollection = rolePermissionCollection;
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
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{"
                + "id=" + id
                + ", name=" + name
                + ", code=" + code
                + ", description=" + description
                + ", isSystem=" + isSystem
                + ", dateCreated=" + dateCreated
                + ", authorId=" + authorId
                + ", userRoleCollection=" + userRoleCollection
                + ", rolePermissionCollection=" + rolePermissionCollection
                + "}";
    }

}
