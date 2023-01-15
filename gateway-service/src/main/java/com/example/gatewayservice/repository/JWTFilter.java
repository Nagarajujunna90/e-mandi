package com.example.gatewayservice.repository;

import com.example.gatewayservice.service.JwtServiceImpl;
import com.example.gatewayservice.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JwtServiceImpl jwtServiceImpl;
    @Autowired
    private CustomUserDetailsService userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authentication");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (token == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
            String userName1 = jwtServiceImpl.getUserNameFromToken(token);

            if (null != userName1 && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName1);
                if (jwtServiceImpl.validateJwtToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken
                            authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null,
                            userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            filterChain.doFilter(request, response);

        }
    }
}
