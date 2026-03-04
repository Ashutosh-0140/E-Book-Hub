package com.example.BookStore.repository;

import com.example.BookStore.db.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Book_repo extends JpaRepository<Books, Long> {
     List<Books> findBybNameContainingIgnoreCase(String b_name);
}
