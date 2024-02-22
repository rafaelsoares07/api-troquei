package com.Troquei.troquei.services;

import com.Troquei.troquei.dtos.UserDTO;
import com.Troquei.troquei.entity.User.User;
import com.Troquei.troquei.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(UserDTO userDTO) {

        User userExist = userRepository.findByEmail(userDTO.email());
        if(userExist != null){
            throw new RuntimeException("Usuario ja existe");
        }
        String passwordHash = passwordEncoder.encode(userDTO.password());
        User userEntity = new User(userDTO.name(),userDTO.email(),passwordHash,userDTO.role());

        return userRepository.save(userEntity);
    }
}
