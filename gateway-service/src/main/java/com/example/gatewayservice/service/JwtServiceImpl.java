package com.example.gatewayservice.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.Jwts.claims;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt_secret}")
    private String jwtSecret;

    @Override
    public String generateJwtToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userName);
        return Jwts.builder().setSubject("user details").
                setClaims(claims).
                setIssuedAt(new Date()).setExpiration(new Date()).
                signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    @Override
    public boolean validateJwtToken(String token, UserDetails userDetails) {
        String userName = getUserNameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired);

    }


    @Override
    public String getUserNameFromToken(String token) {
        Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody();
        return body.getSubject();
    }


}
