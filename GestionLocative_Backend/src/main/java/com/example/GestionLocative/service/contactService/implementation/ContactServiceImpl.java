package com.example.GestionLocative.service.contactService.implementation;


import com.example.GestionLocative.model.Contact;
import com.example.GestionLocative.repository.ContactRepository;
import com.example.GestionLocative.service.contactService.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addNewContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        contactRepository.delete(contact.get());
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Long contact) {
        return contactRepository.findById(contact).get();
    }
}
