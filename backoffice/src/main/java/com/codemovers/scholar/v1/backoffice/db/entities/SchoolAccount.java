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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mover 11/24/2017
 */
@Entity
@Table(name = "school_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolAccount.findAll", query = "SELECT s FROM SchoolAccount s")
    , @NamedQuery(name = "SchoolAccount.findById", query = "SELECT s FROM SchoolAccount s WHERE s.id = :id")
    , @NamedQuery(name = "SchoolAccount.findByName", query = "SELECT s FROM SchoolAccount s WHERE s.name = :name")
    , @NamedQuery(name = "SchoolAccount.findByTimezoneCode", query = "SELECT s FROM SchoolAccount s WHERE s.timezoneCode = :timezoneCode")
    , @NamedQuery(name = "SchoolAccount.findByJoinDate", query = "SELECT s FROM SchoolAccount s WHERE s.joinDate = :joinDate")
    , @NamedQuery(name = "SchoolAccount.findByCreatedDate", query = "SELECT s FROM SchoolAccount s WHERE s.createdDate = :createdDate")
    , @NamedQuery(name = "SchoolAccount.findByLastModified", query = "SELECT s FROM SchoolAccount s WHERE s.lastModified = :lastModified")
    , @NamedQuery(name = "SchoolAccount.findByExternalId", query = "SELECT s FROM SchoolAccount s WHERE s.externalId = :externalId")})
public class SchoolAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "timezone_code")
    private String timezoneCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "external_id")
    private String externalId;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralAccounts general_account;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "schoolAccount")
    private Collection<SchoolServerConnection> schoolServerConnectionCollection;

    public SchoolAccount() {
    }

    public SchoolAccount(Long id) {
        this.id = id;
    }

    public SchoolAccount(Long id, String name, String timezoneCode, Date joinDate, Date createdDate, Date lastModified, String externalId) {
        this.id = id;
        this.name = name;
        this.timezoneCode = timezoneCode;
        this.joinDate = joinDate;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
        this.externalId = externalId;
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

    public String getTimezoneCode() {
        return timezoneCode;
    }

    public void setTimezoneCode(String timezoneCode) {
        this.timezoneCode = timezoneCode;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public GeneralAccounts getGeneral_account() {
        return general_account;
    }

    public void setGeneral_account(GeneralAccounts general_account) {
        this.general_account = general_account;
    }

    public Collection<SchoolServerConnection> getSchoolServerConnectionCollection() {
        return schoolServerConnectionCollection;
    }

    public void setSchoolServerConnectionCollection(Collection<SchoolServerConnection> schoolServerConnectionCollection) {
        this.schoolServerConnectionCollection = schoolServerConnectionCollection;
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
        if (!(object instanceof SchoolAccount)) {
            return false;
        }
        SchoolAccount other = (SchoolAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "[ id=" + id
                + " ]";
    }

}
