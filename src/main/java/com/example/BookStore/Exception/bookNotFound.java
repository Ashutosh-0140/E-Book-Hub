package com.example.BookStore.Exception;

public class bookNotFound extends RuntimeException {
    public bookNotFound(String message){
        super(message);
    }
}
