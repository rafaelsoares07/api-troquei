package com.Troquei.troquei.controllers;

import com.Troquei.troquei.dtos.UserDTO;
import com.Troquei.troquei.entity.User.User;
import com.Troquei.troquei.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    private User create(@RequestBody @Valid UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping
    private String get(){
        return "OK";
    }

}
