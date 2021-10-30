package com.example.GestionLocative.service.imageService;

import com.example.GestionLocative.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface IImageService {
    Image addNewImage(MultipartFile file, Long maisonId) throws IOException;
    Stream<Image> getAllByMaisonId(Long maisonId);
    Image getImage(Long imageId);
    void deleteImage(Long imageId);
}
