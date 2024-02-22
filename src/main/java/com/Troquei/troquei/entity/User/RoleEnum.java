package com.Troquei.troquei.entity.User;

public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleEnum(String Role) {
        this.role = role;
    }
}
