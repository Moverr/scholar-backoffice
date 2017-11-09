/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mover
 */
@Entity
@Table(name = "general_accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralAccounts.findAll", query = "SELECT g FROM GeneralAccounts g")
    , @NamedQuery(name = "GeneralAccounts.findById", query = "SELECT g FROM GeneralAccounts g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralAccounts.findByAccountType", query = "SELECT g FROM GeneralAccounts g WHERE g.accountType = :accountType")
    , @NamedQuery(name = "GeneralAccounts.findByStatus", query = "SELECT g FROM GeneralAccounts g WHERE g.status = :status")
    , @NamedQuery(name = "GeneralAccounts.findByExternalid", query = "SELECT g FROM GeneralAccounts g WHERE g.externalid = :externalid")
    , @NamedQuery(name = "GeneralAccounts.findByDateCreated", query = "SELECT g FROM GeneralAccounts g WHERE g.dateCreated = :dateCreated")})
public class GeneralAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 12)
    @Column(name = "account_type")
    private String accountType;
    @Size(max = 19)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "externalid")
    private String externalid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @OneToMany(mappedBy = "accountId")
    private Collection<Users> usersCollection;

    public GeneralAccounts() {
    }

    public GeneralAccounts(Long id) {
        this.id = id;
    }

    public GeneralAccounts(Long id, Date dateCreated) {
        this.id = id;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternalid() {
        return externalid;
    }

    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
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
        if (!(object instanceof GeneralAccounts)) {
            return false;
        }
        GeneralAccounts other = (GeneralAccounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codemovers.scholar.v1.backoffice.db.entities.GeneralAccounts[ id=" + id + " ]";
    }
    
}