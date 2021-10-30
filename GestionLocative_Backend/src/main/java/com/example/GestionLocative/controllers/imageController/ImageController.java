package com.example.GestionLocative.controllers.imageController;

import com.example.GestionLocative.model.Image;
import com.example.GestionLocative.response.ImageResponse;
import com.example.GestionLocative.response.ResponseMessage;
import com.example.GestionLocative.service.imageService.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/image")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @PostMapping(path = "/upload/{maisonId}")
    public ResponseEntity<ResponseMessage> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Long maisonId) throws IOException {
        String message = "";
        try {
            imageService.addNewImage(file, maisonId);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e){
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/images/{maisonId}")
    public ResponseEntity<List<ImageResponse>> getListImages(@PathVariable Long maisonId) {
        List<ImageResponse> files = imageService.getAllByMaisonId(maisonId).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();
            ImageResponse imageResponse = new ImageResponse();
            imageResponse.setMaisonId(maisonId);
            imageResponse.setName(dbFile.getName());
            imageResponse.setUrl(fileDownloadUri);
            imageResponse.setType(dbFile.getType());
            imageResponse.setSize(dbFile.getData().length);
            return imageResponse;
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }


    @GetMapping(path = "/file/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id){
        Image image = imageService.getImage(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                .body(image.getData());
    }
}
