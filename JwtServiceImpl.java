package com.IES.service.IMPL;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.IES.entity.User;
import com.IES.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public String extractUsername(String token) {
        return token.replace("token_", ""); // simple logic
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String email = extractUsername(token);
        return email.equals(userDetails.getUsername());
    }

    @Override
    public String generateToken(User user) {
        return "token_" + user.getEmail();
    }
}