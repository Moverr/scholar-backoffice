/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.helper.enums;

/**
 *
 * @author Mover 6/4/2017
 */
public enum ContactTypes {
    PHONE, EMAIL, WEBSITE, FAX, WATSAPP, FACEBOOK, LINKEDIN, TWITTER, SNAPCHAT, PINTEREST, OTHERS, INVALID;
    //SOCIALMEDIA

    public static final ContactTypes fromString(String text) {
        ContactTypes returnValue = OTHERS;

        try {
            if (text != null) {
                returnValue = ContactTypes.valueOf(text.toUpperCase());
            }
        } catch (IllegalArgumentException e) {

            returnValue = INVALID;
        }

        return returnValue;
    }

    public static final ContactTypes fromObject(Object text) {
        return fromString(text.toString());
    }
}
