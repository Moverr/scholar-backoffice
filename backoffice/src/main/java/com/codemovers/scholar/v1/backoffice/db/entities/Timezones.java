/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.db.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mover 11/24/2017
 */
@Entity
@Table(name = "timezones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timezones.findAll", query = "SELECT t FROM Timezones t")
    , @NamedQuery(name = "Timezones.findById", query = "SELECT t FROM Timezones t WHERE t.id = :id")
    , @NamedQuery(name = "Timezones.findByCountryCode", query = "SELECT t FROM Timezones t WHERE t.countryCode = :countryCode")
    , @NamedQuery(name = "Timezones.findByTimezonename", query = "SELECT t FROM Timezones t WHERE t.timezonename = :timezonename")
    , @NamedQuery(name = "Timezones.findByComments", query = "SELECT t FROM Timezones t WHERE t.comments = :comments")})
public class Timezones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "country_code")
    private String countryCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "timezonename")
    private String timezonename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comments")
    private String comments;

    public Timezones() {
    }

    public Timezones(Long id) {
        this.id = id;
    }

    public Timezones(Long id, String countryCode, String timezonename, String comments) {
        this.id = id;
        this.countryCode = countryCode;
        this.timezonename = timezonename;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimezonename() {
        return timezonename;
    }

    public void setTimezonename(String timezonename) {
        this.timezonename = timezonename;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        if (!(object instanceof Timezones)) {
            return false;
        }
        Timezones other = (Timezones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codemovers.scholar.v1.backoffice.db.entities.Timezones[ id=" + id + " ]";
    }

}
