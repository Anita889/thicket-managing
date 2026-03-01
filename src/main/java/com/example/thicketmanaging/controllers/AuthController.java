package com.example.thicketmanaging.controllers;

import com.example.thicketmanaging.dtos.AuthResponse;
import com.example.thicketmanaging.dtos.LoginRequest;
import com.example.thicketmanaging.dtos.RegisterRequest;
import com.example.thicketmanaging.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/authentication")
public class AuthController {

    @Autowired
    private  AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody String email, @RequestBody String password) {
            LoginRequest request = new LoginRequest();
            request.setUsername(email);
            request.setPassword(password);
        return authService.login(request);
    }
}