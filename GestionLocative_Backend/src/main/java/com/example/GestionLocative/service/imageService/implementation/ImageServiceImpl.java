package com.example.GestionLocative.service.imageService.implementation;

import com.example.GestionLocative.model.Image;
import com.example.GestionLocative.model.Maison;
import com.example.GestionLocative.repository.ImageRepository;
import com.example.GestionLocative.repository.MaisonRepository;
import com.example.GestionLocative.service.imageService.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
public class ImageServiceImpl implements IImageService {
    @Autowired
    private MaisonRepository maisonRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image addNewImage(MultipartFile file, Long maisonId) throws IOException {
        Optional<Maison> maison = maisonRepository.findById(maisonId);
        if (maison.isEmpty())return null;
        String name = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image();
        image.setMaison(maison.get());
        image.setData(file.getBytes());
        image.setName(name);
        image.setType(file.getContentType());
        return imageRepository.save(image);
    }

    @Override
    public Stream<Image> getAllByMaisonId(Long maisonId) {
        return imageRepository.findAllByMaison_Id(maisonId).stream();
    }

    @Override
    public Image getImage(Long imageId) {
        return imageRepository.findById(imageId).get();
    }

    @Override
    public void deleteImage(Long imageId) {
        Optional<Image> image = imageRepository.findById(imageId);
        imageRepository.delete(image.get());
    }
}
