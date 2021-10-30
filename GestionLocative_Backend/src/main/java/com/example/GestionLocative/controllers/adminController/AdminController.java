package com.example.GestionLocative.controllers.adminController;

import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.response.AdminResponse;
import com.example.GestionLocative.service.adminService.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    //test done
    @GetMapping
    private List<AdminResponse> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    //test done
    @PostMapping()
    private AdminResponse addNewAdmin(@RequestBody Admin admin){
        return adminService.addNewAdmn(admin);
    }

    //test done
    @DeleteMapping(path = "/{adminId}")
    private void deleteAdmin(@PathVariable String adminId){
        adminService.deleteAdmin(adminId);
    }

    //test done
    @GetMapping(path = "/{adminId}")
    private AdminResponse getAdmin(@PathVariable String adminId){
        return adminService.getAdmin(adminId);
    }

}
