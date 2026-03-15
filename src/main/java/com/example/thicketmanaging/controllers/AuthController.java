package com.example.thicketmanaging.controllers;

import com.example.thicketmanaging.dtos.AuthResponse;
import com.example.thicketmanaging.dtos.LoginRequest;
import com.example.thicketmanaging.dtos.RegisterRequest;
import com.example.thicketmanaging.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private  AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthResponse login(@RequestBody LoginRequest request) {
            request.setUsername(request.getUsername());
            request.setPassword(request.getPassword());
        return authService.login(request);
    }
}