package com.example.springsecurity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {
    @Value("${jwt_secret}")
    private String jwtSecret;

    public String generateJwtToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userName);
        return Jwts.builder().setSubject("user details").
                setClaims(claims).
                setIssuedAt(new Date()).setExpiration(new Date()).
                signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }

    public boolean validateJwtToken(String token, UserDetails userDetails) {
        String userName = getUserNameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired);

    }


    public String getUserNameFromToken(String token) {
        Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody();
        return body.getSubject();
    }


}
