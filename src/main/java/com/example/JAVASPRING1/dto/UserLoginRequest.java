package com.example.JAVASPRING1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    private String userName;
    private String password;
}
