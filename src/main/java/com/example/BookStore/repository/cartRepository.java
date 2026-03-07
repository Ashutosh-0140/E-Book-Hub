package com.example.BookStore.repository;

import com.example.BookStore.db.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface cartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);
}