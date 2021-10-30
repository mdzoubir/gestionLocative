package com.example.GestionLocative.repository;

import com.example.GestionLocative.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestResource
@CrossOrigin("*")
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
