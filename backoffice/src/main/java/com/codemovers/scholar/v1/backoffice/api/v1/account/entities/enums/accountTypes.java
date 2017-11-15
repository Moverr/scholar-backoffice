/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.account.entities.enums;

/**
 *
 * @author MOVER 11/5/2017
 */
public enum accountTypes {
    INVALID(0, "INVALID"),
    PERSON(1, "PERSON"),
    ORGANISATION(2, "ORGANISATION"),
    COMPANY(3, "COMPANY"),
    SCHOLAR(4, "SCHOLAR");

    private final Integer id;
    private final String code;
    private final String value;

    private accountTypes(Integer id, String code, String value) {
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

    public static accountTypes fromInt(final Integer accountType) {
        accountTypes _accountType = accountTypes.INVALID;

        if (accountType != null) {
            switch (accountType) {
                case 1:
                    _accountType = accountTypes.PERSON;
                    break;
                case 2:
                    _accountType = accountTypes.ORGANISATION;
                    break;
                case 3:
                    _accountType = accountTypes.COMPANY;
                    break;
                case 4:
                    _accountType = accountTypes.SCHOLAR;
                    break;
                default:
                    _accountType = INVALID;
                    break;
            }
        }

        return _accountType;
    }


}
