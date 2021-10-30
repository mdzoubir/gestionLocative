package com.example.GestionLocative.controllers.cleaningController;

import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.model.Cleaning;
import com.example.GestionLocative.model.Client;
import com.example.GestionLocative.response.CleaningResponse;
import com.example.GestionLocative.service.adminService.IAdminService;
import com.example.GestionLocative.service.cleaningService.ICleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/cleaning")
public class CleaningController {

    @Autowired
    private ICleaningService cleaningService;

    @GetMapping(path = "/{cleaningId}")
    private CleaningResponse getCleaning(@PathVariable Long cleaningId){
        return cleaningService.getCleaning(cleaningId);
    }

    @PutMapping(path = "/{maisonId}")
    private CleaningResponse updateCleaning(@PathVariable Long maisonId, @RequestBody Cleaning cleaning){
        return cleaningService.updateCleaning(maisonId, cleaning);
    }
}
