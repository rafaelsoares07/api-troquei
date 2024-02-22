package com.Troquei.troquei.services;

import com.Troquei.troquei.dtos.AuthDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    public String getToken(AuthDTO authDTO);
}
