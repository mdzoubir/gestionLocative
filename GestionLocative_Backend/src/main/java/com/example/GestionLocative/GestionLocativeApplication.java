package com.example.GestionLocative;

import com.example.GestionLocative.model.Admin;
import com.example.GestionLocative.model.Role;
import com.example.GestionLocative.service.adminService.IAdminService;
import com.example.GestionLocative.service.roleService.IRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class GestionLocativeApplication {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionLocativeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			IRoleService roleService,
			IAdminService adminService
	){
		return args -> {
			//add new role
			roleService.addNewRole(new Role(null, "ADMIN"));
			roleService.addNewRole(new Role(null, "CLIENT"));


			//add new admin
			Admin admin = new Admin();
			admin.setEmail("admin@gmail.com");
			admin.setFirstName("admin");
			admin.setLastName("admin");
			admin.setPassword("12345");
			admin.setPhoneNumber("0617198646");
			adminService.addNewAdmn(admin);
		};
	}

}
