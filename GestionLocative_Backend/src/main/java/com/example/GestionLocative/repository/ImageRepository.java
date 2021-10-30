package com.example.GestionLocative.repository;

import com.example.GestionLocative.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestResource
@CrossOrigin("*")
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByMaison_Id(Long imageId);
}
