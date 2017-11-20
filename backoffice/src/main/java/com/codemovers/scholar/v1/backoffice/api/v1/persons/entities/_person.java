/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.persons.entities;

import java.util.Objects;

/**
 *
 * @author Mover 11/19/2017
 */
public class _person {

    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private String marital_status;
    private String image_url;

    public _person() {
    }

    public _person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.firstname);
        hash = 83 * hash + Objects.hashCode(this.lastname);
        hash = 83 * hash + Objects.hashCode(this.gender);
        hash = 83 * hash + Objects.hashCode(this.marital_status);
        hash = 83 * hash + Objects.hashCode(this.image_url);
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
        final _person other = (_person) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.marital_status, other.marital_status)) {
            return false;
        }
        if (!Objects.equals(this.image_url, other.image_url)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                + "{"
                + "id=" + id
                + ", firstname=" + firstname
                + ", lastname=" + lastname
                + ", gender=" + gender
                + ", marital_status=" + marital_status
                + ", image_url=" + image_url
                + "}";
    }


}
