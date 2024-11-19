package com.project.sbws.backend.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.project.sbws.backend.models.AuthRequest;
import com.project.sbws.backend.utilities.JwtUtility;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtUtility jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtility jwtUtil, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public String authenticate(@org.springframework.web.bind.annotation.RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        return jwtUtil.generateToken(authRequest.getUsername());
    }

    @PostMapping("/register")
    public String register(@org.springframework.web.bind.annotation.RequestBody AuthRequest authRequest) {
        // Save user to DB (skipped here, assume user is saved with encoded password)
        return "User registered successfully";
    }
}


