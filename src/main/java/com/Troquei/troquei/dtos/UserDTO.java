package com.Troquei.troquei.dtos;

import com.Troquei.troquei.entity.User.RoleEnum;

public record UserDTO(
        String name,
        String email,
        String password,
        RoleEnum role
) {

}
