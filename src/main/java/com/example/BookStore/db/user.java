package com.example.BookStore.db;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String password;
    private String mailId;
    private String role;
}
