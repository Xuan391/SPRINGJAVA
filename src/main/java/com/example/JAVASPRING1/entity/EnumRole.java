package com.example.JAVASPRING1.entity;

import lombok.Getter;

public enum EnumRole {
    ROLE_ADMIN("ROLE_USER"),
    ROLE_USER("ROLE_ADMIN");
    @Getter
    private final String value;
    private EnumRole(String value) {
        this.value = value;
    }
}
