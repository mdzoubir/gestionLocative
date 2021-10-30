package com.example.GestionLocative.service.adminService.implementation;

import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.repository.AdminRepository;
import com.example.GestionLocative.response.AdminResponse;
import com.example.GestionLocative.service.accountService.IAccountService;
import com.example.GestionLocative.service.adminService.IAdminService;
import com.example.GestionLocative.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private Utils utils;

    @Autowired
    private IAccountService accountService;

    @Override
    public AdminResponse addNewAdmn(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setUserId(utils.generateUserID(32));
        Admin a = adminRepository.save(admin);
        accountService.addRoleToUser(admin.getEmail(), "ADMIN");
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(a, adminResponse);
        return adminResponse;
    }

    @Override
    public List<AdminResponse> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponses = new ArrayList<>();
        for(Admin admin : admins){
            AdminResponse adminResponse = new AdminResponse();
            BeanUtils.copyProperties(admin, adminResponse);
            adminResponses.add(adminResponse);
        }
        return adminResponses;
    }

    @Override
    public AdminResponse getAdmin(String adminId) {
        Optional<Admin> admin = adminRepository.findByUserId(adminId);
        if (admin.isEmpty()) return null;
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(admin.get(), adminResponse);
        return adminResponse;
    }

    @Override
    public void deleteAdmin(String adminId) {
        Optional<Admin> admin = adminRepository.findByUserId(adminId);
        adminRepository.delete(admin.get());
    }
}
