package com.example.GestionLocative.service.accountService.implementation;


import com.example.GestionLocative.model.AppUser;
import com.example.GestionLocative.model.Role;
import com.example.GestionLocative.repository.AppUserRepository;
import com.example.GestionLocative.repository.RoleRepository;
import com.example.GestionLocative.service.accountService.IAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AccountServiceImpl implements IAccountService {


  private final AppUserRepository appUserRepository;
  private RoleRepository appRoleRepository;
  private PasswordEncoder passwordEncoder;

  public AccountServiceImpl(AppUserRepository appUserRepository, RoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
    this.appUserRepository = appUserRepository;
    this.appRoleRepository = appRoleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public AppUser addNewUser(AppUser appUser) {
    String pw = appUser.getPassword();
    appUser.setPassword(passwordEncoder.encode(pw));
    return appUserRepository.save(appUser);
  }

  @Override
  public Role addNewRole(Role appRole) {
    return appRoleRepository.save(appRole);
  }

  @Override
  public void addRoleToUser(String email, String rolename) {
    Optional<AppUser> appUser = appUserRepository.findByEmail(email);
    Optional<Role> appRole = appRoleRepository.findByRole(rolename);
    appUser.get().getRoles().add(appRole.get());
  }

  @Override
  public AppUser loadUserByUsername(String email) {
    return appUserRepository.findByEmail(email).get();
  }

  @Override
  public List<AppUser> listUsers() {
    return appUserRepository.findAll();
  }
}
