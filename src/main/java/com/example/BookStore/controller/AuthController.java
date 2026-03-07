package com.example.BookStore.controller;

import com.example.BookStore.DTO.LoginRequest;
import com.example.BookStore.db.user;
import com.example.BookStore.service.User_Service;
import com.example.BookStore.JWT.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private User_Service userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public user register(@RequestBody user newUser) {
        return userService.registerUser(newUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest login, String role) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUserName(),
                        login.getPassword()
                )
        );

        // If authentication succeeds, generate JWT
        String token = jwtUtil.generateToken(login.getUserName(), role);
        return token;
    }
}