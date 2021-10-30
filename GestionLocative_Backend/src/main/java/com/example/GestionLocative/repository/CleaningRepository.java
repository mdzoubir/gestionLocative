package com.example.GestionLocative.repository;

import com.example.GestionLocative.model.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestResource
@CrossOrigin("*")
public interface CleaningRepository extends JpaRepository<Cleaning, Long> {
}
