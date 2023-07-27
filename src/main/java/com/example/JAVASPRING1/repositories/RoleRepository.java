package com.example.JAVASPRING1.repositories;

import com.example.JAVASPRING1.entity.EnumRole;
import com.example.JAVASPRING1.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(EnumRole roleName);
}
