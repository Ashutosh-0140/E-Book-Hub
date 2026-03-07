package com.example.BookStore.service;

import com.example.BookStore.db.user;
import com.example.BookStore.repository.user_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class User_Service {
    @Autowired
    private user_Repo ur1;

    @Autowired
    private BCryptPasswordEncoder p1;


    public user registerUser(user User){
        String EncodedPassword = p1.encode(User.getPassword());
        User.setPassword(EncodedPassword);
        return ur1.save(User);

    }

    public user userRegister(user u1){
        u1.setRole("USER");
        return ur1.save(u1);
    }
}
