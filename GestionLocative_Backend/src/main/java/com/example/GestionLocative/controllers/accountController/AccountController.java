package com.example.GestionLocative.controllers.accountController;

import com.example.GestionLocative.model.AppUser;
import com.example.GestionLocative.service.accountService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping(path = "/profile")
    public ResponseEntity<AppUser> profile(Principal principal) {
      AppUser appUser = accountService.loadUserByUsername(principal.getName());
      return new ResponseEntity<>(appUser, HttpStatus.ACCEPTED);
    }

}
