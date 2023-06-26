package com.example.springsecurity.controller;

import com.example.springsecurity.model.Login;
import com.example.springsecurity.service.JwtUtil;
import com.example.springsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody Login
                                                 request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new  UsernamePasswordAuthenticationToken(request.getUserName(),
                            request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUserName());
        final String jwtToken = jwtUtil.generateJwtToken(userDetails.getUsername());
        return ResponseEntity.ok(jwtToken);
    }
}
