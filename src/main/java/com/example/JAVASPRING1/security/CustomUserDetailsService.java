package com.example.JAVASPRING1.security;

import com.example.JAVASPRING1.entity.Users;
import com.example.JAVASPRING1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if(user == null){
            throw  new UsernameNotFoundException("user is not found");
        }
        return CustomUserDetails.mapUserToUserDetail(user);
    }
}
