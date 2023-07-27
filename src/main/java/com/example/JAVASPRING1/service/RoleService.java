package com.example.JAVASPRING1.service;

import com.example.JAVASPRING1.entity.EnumRole;
import com.example.JAVASPRING1.entity.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRoleName(EnumRole roleName);
}
