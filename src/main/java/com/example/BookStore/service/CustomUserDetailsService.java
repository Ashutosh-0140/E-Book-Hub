package com.example.BookStore.service;

import com.example.BookStore.db.user;
import com.example.BookStore.repository.user_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private user_Repo ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user userEntity = ur.findByuserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        // ✅ Map DB role ("USER"/"ADMIN") to Spring authority ("ROLE_USER"/"ROLE_ADMIN")
        List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole()));

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUserName(),
                userEntity.getPassword(),
                authorities
        );
    }
}