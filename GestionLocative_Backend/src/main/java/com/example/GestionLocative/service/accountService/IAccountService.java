package com.example.GestionLocative.service.accountService;


import com.example.GestionLocative.model.AppUser;
import com.example.GestionLocative.model.Role;

import java.util.List;

public interface IAccountService {
  AppUser addNewUser(AppUser appUser);

  Role addNewRole(Role appRole);

  void addRoleToUser(String username, String rolename);

  AppUser loadUserByUsername(String username);

  List<AppUser> listUsers();
}
