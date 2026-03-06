package com.example.BookStore.controller;

import com.example.BookStore.DTO.LoginRequest;
import com.example.BookStore.db.user;
import com.example.BookStore.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager AuthenticationManager;

    @Autowired
    private User_Service service1;

    @PostMapping("/register")
    public user register(@RequestBody user User){
        return service1.registerUser(User);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest login) {
        Authentication authentication = AuthenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUserName(),
                        login.getPassword()));

        // If authentication succeeds, return a token or session info
        return "Login Successful";
    }
}
