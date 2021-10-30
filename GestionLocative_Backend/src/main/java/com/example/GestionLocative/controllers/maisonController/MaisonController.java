package com.example.GestionLocative.controllers.maisonController;


import com.example.GestionLocative.model.Maison;
import com.example.GestionLocative.response.MaisonResponse;
import com.example.GestionLocative.service.maisonService.IMaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/maison")
public class MaisonController {

    @Autowired
    private IMaisonService maisonService;

    @GetMapping
    private List<MaisonResponse> getAllMaison(){
        return maisonService.getAllMaison();
    }

    @PostMapping(path = "/{clientId}/{adminId}")
    private MaisonResponse addNewMaison(@RequestBody Maison maison, @PathVariable String adminId, @PathVariable String clientId){
        return maisonService.addNewMaison(maison, clientId, adminId);
    }

    @DeleteMapping(path = "/{maisonId}")
    private void deleteMaison(@PathVariable Long maisonId){
        maisonService.deleteMaison(maisonId);
    }

    @GetMapping(path = "/{maisonId}")
    private MaisonResponse getMaison(@PathVariable Long maisonId){
        return maisonService.getMaison(maisonId);
    }
}
