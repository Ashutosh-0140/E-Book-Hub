package com.example.BookStore.repository;

import com.example.BookStore.db.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface user_Repo extends JpaRepository<user, Long> {
    Optional<user> findByMailId(String email);

    Optional<user> findByuserName(String userName);
}