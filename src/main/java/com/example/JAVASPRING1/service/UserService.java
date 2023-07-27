package com.example.JAVASPRING1.service;

import com.example.JAVASPRING1.entity.Users;

public interface UserService {
    Users findByUserName(String userName);
    boolean existsByUserName(String UserName);
    Users saveOrUpdate(Users user);
}
