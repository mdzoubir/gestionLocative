package com.example.GestionLocative.service.userDetailsService;


import com.example.GestionLocative.model.AppUser;
import com.example.GestionLocative.service.accountService.IAccountService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private com.example.GestionLocative.service.accountService.IAccountService IAccountService;

  public UserDetailsServiceImpl(IAccountService IAccountService) {
    this.IAccountService = IAccountService;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    AppUser appUser = IAccountService.loadUserByUsername(email);
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    appUser.getRoles().forEach(appRole -> {
      authorities.add(new SimpleGrantedAuthority(appRole.getRole()));
    });
    return new User(appUser.getEmail(), appUser.getPassword(), authorities);
  }
}
