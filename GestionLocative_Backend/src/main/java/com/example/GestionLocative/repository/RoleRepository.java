package com.example.GestionLocative.repository;

import com.example.GestionLocative.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RestResource
@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String roleName);
}
