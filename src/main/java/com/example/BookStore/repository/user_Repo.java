package com.example.BookStore.repository;

import com.example.BookStore.db.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface user_Repo extends JpaRepository<user, Long> {
    Optional<user>findBymailId(String email);  //Because E mail for a user may or may not be available
    Optional<user>findByuserName(String userName);
}
