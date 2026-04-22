package com.IES.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.IES.dto.AuthRequest;
import com.IES.entity.User;
import com.IES.service.JwtService;

@RestController
@RequestMapping("/ies/v1/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authManager,
                          JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // ✅ IMPORTANT FIX
        User user = (User) authentication.getPrincipal();

        return jwtService.generateToken(user);
    }
}