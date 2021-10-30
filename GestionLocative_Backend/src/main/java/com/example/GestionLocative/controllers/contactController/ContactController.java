package com.example.GestionLocative.controllers.contactController;

import com.example.GestionLocative.model.Contact;
import com.example.GestionLocative.service.contactService.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/contact")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping
    public List<Contact> getAllContact() {
        return contactService.getAllContacts();
    }


    @PostMapping
    public Contact addNewContact(Contact contact){
        return contactService.addNewContact(contact);
    }

    @GetMapping(path = "/{contactId}")
    public  Contact getContact(@PathVariable Long contactId){
        return contactService.getContact(contactId);
    }
}
