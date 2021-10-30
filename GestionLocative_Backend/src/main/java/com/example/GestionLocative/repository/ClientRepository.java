package com.example.GestionLocative.repository;

import com.example.GestionLocative.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.Optional;

@RestResource
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client>findByUserId(String clientId);
}
