/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.persons.enums;

/**
 *
 * @author MOVER 11/5/2017
 */
public enum MaritalStatus {
    INVALID(0, "INVALID", "invalid"),
    SINGLE(1, "SINGLE", "single"),
    MARRIED(2, "MARRIED", "married");

    private final Integer id;
    private final String code;
    private final String value;

    private MaritalStatus(Integer id, String code, String value) {
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

    public static MaritalStatus fromInt(final Integer maritalstatus) {
        MaritalStatus _marital_status = MaritalStatus.INVALID;

        if (maritalstatus != null) {
            switch (maritalstatus) {
                case 1:
                    _marital_status = MaritalStatus.SINGLE;
                    break;
                case 2:
                    _marital_status = MaritalStatus.MARRIED;
                    break;

                default:
                    _marital_status = INVALID;
                    break;
            }
        }

        return _marital_status;
    }


}
