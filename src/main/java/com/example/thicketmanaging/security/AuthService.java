package com.example.thicketmanaging.security;

import com.example.thicketmanaging.dtos.AuthResponse;
import com.example.thicketmanaging.dtos.LoginRequest;
import com.example.thicketmanaging.dtos.RegisterRequest;
import com.example.thicketmanaging.entities.User;
import com.example.thicketmanaging.enums.UserRole;
import com.example.thicketmanaging.repositories.UserRepository;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserRole(UserRole.ADMIN);

        userRepository.save(user);

        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                )
        );

        return new AuthResponse(token, user.getUserRole().name());
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsernameIgnoreCase(request.getUsername()).get();

        if (!passwordEncoder.matches(
                request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority(
                                "ROLE_" + user.getUserRole().name()))
                )
        );

        return new AuthResponse(token, user.getUserRole().name());
    }
}