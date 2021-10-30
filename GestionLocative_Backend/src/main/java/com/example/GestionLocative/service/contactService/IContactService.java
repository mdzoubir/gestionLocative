package com.example.GestionLocative.service.contactService;


import com.example.GestionLocative.model.Contact;

import java.util.List;

public interface IContactService {
    Contact addNewContact(Contact contact);
    void deleteContact(Long contactId);
    List<Contact> getAllContacts();
    Contact getContact(Long contact);
}
