package com.example.JAVASPRING1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // khi lay user ve thi lay tat ca cac role cua no
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> listRoles = new HashSet<>();

}
