package com.example.BookStore.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class user {
    @Id
    @GeneratedValue
    private Long userId;

    private String userName;
    private String password;
    private String mailId;
    private String role;
}
