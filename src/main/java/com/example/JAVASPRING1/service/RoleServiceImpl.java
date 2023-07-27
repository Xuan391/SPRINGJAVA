package com.example.JAVASPRING1.service;

import com.example.JAVASPRING1.entity.EnumRole;
import com.example.JAVASPRING1.entity.Roles;
import com.example.JAVASPRING1.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Roles> findByRoleName(EnumRole roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
