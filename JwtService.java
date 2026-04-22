package com.IES.service;
import org.springframework.security.core.userdetails.UserDetails;

import com.IES.entity.User;

public interface JwtService {

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(User user);
}