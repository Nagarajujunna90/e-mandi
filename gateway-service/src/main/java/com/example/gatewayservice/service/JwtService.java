package com.example.gatewayservice.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateJwtToken(String email);

    boolean validateJwtToken(String token, UserDetails userDetails);


    String getUserNameFromToken(String token);
}
