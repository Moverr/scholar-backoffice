/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.users.enums;

/**
 *
 * @author MOVER 11/5/2017
 */
public enum RolesEnum {
    INVALID(0, "INVALID", false),
    ADMIN(1, "MALE", true),
    SYSTEMADMIN(2, "FEMALE", true);


    private final Integer id;
    private final String code;
    private final boolean isSystem;

    private RolesEnum(Integer id, String code, boolean value) {
        this.id = id;
        this.code = code;
        this.isSystem = value;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public boolean isIsSystem() {
        return isSystem;
    }

    public static RolesEnum fromInt(final Integer role) {
        RolesEnum _role = RolesEnum.INVALID;

        if (role != null) {
            switch (role) {
                case 1:
                    _role = RolesEnum.ADMIN;
                    break;
                case 2:
                    _role = RolesEnum.SYSTEMADMIN;
                    break;

                default:
                    _role = INVALID;
                    break;
            }
        }

        return _role;
    }

    public static boolean roleStatus(final String rolenme) {
        boolean _status = false;
        if (rolenme != null) {
            switch (rolenme) {
                case "ADMIN":
                    _status = true;
                    break;
                case "SUPERADMIN":
                    _status = true;
                    break;

                default:
                    _status = false;
                    break;
            }
        }

        return _status;
    }




}
