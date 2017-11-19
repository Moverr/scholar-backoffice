/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.persons.enums;

import com.codemovers.scholar.v1.backoffice.api.v1.accounts.entities.enums.*;

/**
 *
 * @author MOVER 11/5/2017
 */
public enum Gender {
    INVALID(0, "INVALID", "invalid"),
    MALE(1, "MALE", "male"),
    FEMALE(2, "FEMALE", "female");


    private final Integer id;
    private final String code;
    private final String value;

    private Gender(Integer id, String code, String value) {
        this.id = id;
        this.code = code;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static Gender fromInt(final Integer accountType) {
        Gender _gender = Gender.INVALID;

        if (accountType != null) {
            switch (accountType) {
                case 1:
                    _gender = Gender.MALE;
                    break;
                case 2:
                    _gender = Gender.FEMALE;
                    break;

                default:
                    _gender = INVALID;
                    break;
            }
        }

        return _gender;
    }


}
