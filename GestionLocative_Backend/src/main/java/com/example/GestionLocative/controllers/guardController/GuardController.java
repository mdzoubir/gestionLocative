package com.example.GestionLocative.controllers.guardController;


import com.example.GestionLocative.model.Guard;
import com.example.GestionLocative.response.GuardResponse;
import com.example.GestionLocative.service.guardService.IGuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/Guard")
public class GuardController {

    @Autowired
    private IGuardService guardService;

    @GetMapping(path = "/{guardId}")
    private GuardResponse getGuard(@PathVariable Long guardId){
        return guardService.getGuard(guardId);
    }

    @PutMapping(path = "/{maisonId}")
    private GuardResponse updateGuard(@PathVariable Long maisonId, @RequestBody Guard guard){
        return guardService.updateGuard(maisonId, guard);
    }
}
