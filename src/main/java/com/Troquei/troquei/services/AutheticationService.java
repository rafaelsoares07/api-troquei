package com.Troquei.troquei.services;

import com.Troquei.troquei.dtos.AuthDTO;
import com.Troquei.troquei.entity.User.User;
import com.Troquei.troquei.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class AutheticationService implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    @Override
    public String getToken(AuthDTO authDTO) {
        User user = userRepository.findByEmail(authDTO.email());
        return generateToken(user);
    }

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("SECRET_KEY");

            return JWT.create()
                    .withIssuer("api-troquei")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateDataExpires())
                    .sign(algorithm);

        }catch (JWTCreationException expection){
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public Instant generateDataExpires(){
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token){

        try{
            Algorithm algorithm = Algorithm.HMAC256("SECRET_KEY");
            return JWT.require(algorithm)
                    .withIssuer("api-troquei")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException exception){
            return null;
        }
    }
}
