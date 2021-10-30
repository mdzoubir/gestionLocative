package com.example.GestionLocative.config.security;

import com.example.GestionLocative.filter.JwtAuthenticationFilter;
import com.example.GestionLocative.filter.JwtAutorizationFilter;
import com.example.GestionLocative.service.accountService.IAccountService;
import com.example.GestionLocative.service.userDetailsService.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private UserDetailsServiceImpl userDetailsService;

  private IAccountService accountService;

  public SecurityConfig(UserDetailsServiceImpl userDetailsService, IAccountService accountService) {
    this.userDetailsService = userDetailsService;
    this.accountService = accountService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.headers().frameOptions().disable();
    http.authorizeRequests().
            antMatchers(HttpMethod.POST, "/login/**").permitAll().
            antMatchers(HttpMethod.POST, "/api/v1/contact/**").permitAll();

    http.authorizeRequests().anyRequest().authenticated();
    http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
    http.addFilterBefore(new JwtAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

  }


  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
