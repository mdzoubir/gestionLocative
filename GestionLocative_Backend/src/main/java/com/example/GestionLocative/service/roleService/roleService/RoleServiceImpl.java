package com.example.GestionLocative.service.roleService.roleService;

import com.example.GestionLocative.model.Role;
import com.example.GestionLocative.repository.RoleRepository;
import com.example.GestionLocative.service.roleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }
}
