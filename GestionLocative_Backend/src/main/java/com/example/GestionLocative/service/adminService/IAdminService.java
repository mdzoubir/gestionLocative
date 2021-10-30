package com.example.GestionLocative.service.adminService;

import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.response.AdminResponse;

import java.util.List;

public interface IAdminService {
    AdminResponse addNewAdmn(Admin admin);
    List<AdminResponse> getAllAdmins();
    AdminResponse getAdmin(String adminId);
    void deleteAdmin(String adminId);
}
