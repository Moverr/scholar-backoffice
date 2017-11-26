/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mover 11/24/2017
 */
@Entity
@Table(name = "school_server_connection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolServerConnection.findAll", query = "SELECT s FROM SchoolServerConnection s")
    , @NamedQuery(name = "SchoolServerConnection.findById", query = "SELECT s FROM SchoolServerConnection s WHERE s.id = :id")
    , @NamedQuery(name = "SchoolServerConnection.findBySchemaServer", query = "SELECT s FROM SchoolServerConnection s WHERE s.schemaServer = :schemaServer")
    , @NamedQuery(name = "SchoolServerConnection.findBySchemaName", query = "SELECT s FROM SchoolServerConnection s WHERE s.schemaName = :schemaName")
    , @NamedQuery(name = "SchoolServerConnection.findBySchemaUsername", query = "SELECT s FROM SchoolServerConnection s WHERE s.schemaUsername = :schemaUsername")
    , @NamedQuery(name = "SchoolServerConnection.findBySchemaPassword", query = "SELECT s FROM SchoolServerConnection s WHERE s.schemaPassword = :schemaPassword")
    , @NamedQuery(name = "SchoolServerConnection.findByAccountid", query = "SELECT s FROM SchoolServerConnection s WHERE s.schoolAccount.id = :schoolAccountId")

})
public class SchoolServerConnection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "schema_server")
    private String schemaServer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "schema_name")
    private String schemaName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "schema_username")
    private String schemaUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "schema_password")
    private String schemaPassword;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "engine_url")
    private String engineurl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentDb")
    private Collection<SchoolServerConnection> schoolServerConnectionCollection;
    @JoinColumn(name = "parent_db", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SchoolServerConnection parentDb;
    @JoinColumn(name = "school_account", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SchoolAccount schoolAccount;

    public SchoolServerConnection() {
    }

    public SchoolServerConnection(Integer id) {
        this.id = id;
    }

    public SchoolServerConnection(Integer id, String schemaServer, String schemaName, String schemaUsername, String schemaPassword) {
        this.id = id;
        this.schemaServer = schemaServer;
        this.schemaName = schemaName;
        this.schemaUsername = schemaUsername;
        this.schemaPassword = schemaPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchemaServer() {
        return schemaServer;
    }

    public void setSchemaServer(String schemaServer) {
        this.schemaServer = schemaServer;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSchemaUsername() {
        return schemaUsername;
    }

    public void setSchemaUsername(String schemaUsername) {
        this.schemaUsername = schemaUsername;
    }

    public String getSchemaPassword() {
        return schemaPassword;
    }

    public void setSchemaPassword(String schemaPassword) {
        this.schemaPassword = schemaPassword;
    }

    public String getEngineurl() {
        return engineurl;
    }

    public void setEngineurl(String engineurl) {
        this.engineurl = engineurl;
    }


    @XmlTransient
    public Collection<SchoolServerConnection> getSchoolServerConnectionCollection() {
        return schoolServerConnectionCollection;
    }

    public void setSchoolServerConnectionCollection(Collection<SchoolServerConnection> schoolServerConnectionCollection) {
        this.schoolServerConnectionCollection = schoolServerConnectionCollection;
    }

    public SchoolServerConnection getParentDb() {
        return parentDb;
    }

    public void setParentDb(SchoolServerConnection parentDb) {
        this.parentDb = parentDb;
    }

    public SchoolAccount getSchoolAccount() {
        return schoolAccount;
    }

    public void setSchoolAccount(SchoolAccount schoolAccount) {
        this.schoolAccount = schoolAccount;
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
        if (!(object instanceof SchoolServerConnection)) {
            return false;
        }
        SchoolServerConnection other = (SchoolServerConnection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{ id=" + id
                + " }";
    }

}
