package com.example.JAVASPRING1.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserSigninRequest {
    private String userName;
    private String password;
    private Set<String> listRoles;
}
