package com.example.BookStore.service;

import com.example.BookStore.db.user;
import com.example.BookStore.repository.user_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class User_Service {

    @Autowired
    private user_Repo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public user registerUser(user newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepo.save(newUser);
    }

    public user findByUserName(String userName) {
        return userRepo.findByuserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}