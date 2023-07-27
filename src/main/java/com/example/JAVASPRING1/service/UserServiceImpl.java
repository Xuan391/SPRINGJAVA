package com.example.JAVASPRING1.service;

import com.example.JAVASPRING1.entity.Users;
import com.example.JAVASPRING1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public Users saveOrUpdate(Users user) {
        return userRepository.save(user);
    }

}
