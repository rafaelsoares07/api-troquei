package com.Troquei.troquei.controllers;

import com.Troquei.troquei.dtos.AuthDTO;
import com.Troquei.troquei.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String auth(@RequestBody AuthDTO authDTO){
        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        authenticationManager.authenticate(userAuthenticationToken);
        return authenticationService.getToken(authDTO);
    }
}
