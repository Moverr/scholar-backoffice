/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice.api.v1.contacts;

import com.codemovers.scholar.v1.backoffice.api.v1.abstracts.AbstractService;
import com.codemovers.scholar.v1.backoffice.api.v1.contacts.entities.ContactsResponse;
import com.codemovers.scholar.v1.backoffice.api.v1.contacts.entities._contacts;
import com.codemovers.scholar.v1.backoffice.db.controllers.ContactsJpaController;
import com.codemovers.scholar.v1.backoffice.db.entities.Contacts;
import com.codemovers.scholar.v1.backoffice.helper.enums.ContactTypes;
import com.codemovers.scholar.v1.backoffice.helper.enums.StatusEnum;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author Mover 11/23/2017
 */
public class ContactsService extends AbstractService<_contacts, ContactsResponse> {

    private static final Logger LOG = Logger.getLogger(ContactsService.class.getName());
    private final ContactsJpaController controller;
    private static ContactsService service = null;

    public ContactsService() {
        controller = ContactsJpaController.getInstance();
    }

    public static ContactsService getInstance() {
        if (service == null) {
            service = new ContactsService();
        }
        return service;
    }


    @Override
    public ContactsResponse create(_contacts entity) throws Exception {
        boolean status = entity.validate();
        if (status == false) {
            throw new BadRequestException("Fill Mandatories");
        }

        Contacts contacts = new Contacts();

        ContactTypes contactType = ContactTypes.fromString(entity.getContactType());
        if (contactType.equals(ContactTypes.INVALID)) {
            throw new BadRequestException("Contact Type is Invalid");
        }

        contacts.setContactType(contactType.toString());
        contacts.setDetails(entity.getDetails());
        contacts.setStatus(StatusEnum.ACTIVE.toString());

        contacts.setParentId(entity.getParentId());
        contacts.setParentType(entity.getParentType());

        contacts = controller.create(contacts);
        return populateResponse(contacts);

    }


    @Override
    public ContactsResponse getById(Integer Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ContactsResponse populateResponse(Contacts contacts) {

        ContactsResponse response = new ContactsResponse();
        response.setId(contacts.getId());
        response.setParentType(contacts.getParentType());
        response.setParentId(contacts.getParentId());
        response.setContactType(contacts.getContactType());
        response.setDetails(contacts.getDetails());
        response.setStatus(contacts.getStatus());

        return response;
    }
}
