package com.IES.service.IMPL;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.IES.dto.LoginRequestDTO;
import com.IES.dto.SignUpDto;
import com.IES.entity.User;
import com.IES.repository.UserRepository;
import com.IES.service.JwtService;
import com.IES.service.UserService;

import com.IES.dto.LoginResponseDTO;
import com.IES.dto.ForgetpasswordDto;

import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // ✅ ADD THIS CONSTRUCTOR HERE
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           JwtService jwtService,
                           AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // your methods...

    @Override
    public String signUp(SignUpDto dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhno(dto.getPhno());
        user.setPwd(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole()); // or Role.USER

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String forgetPassword(ForgetpasswordDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return "Password reset link sent to email";
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return new LoginResponseDTO(jwtToken, "Login Successful");
    }
}