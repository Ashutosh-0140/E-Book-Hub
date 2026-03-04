package com.example.BookStore.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(bookNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public Map<String,Object> handleException(bookNotFound ex){
        Map<String, Object> m1 = new HashMap<>();
        m1.put("message",ex.getMessage());
        m1.put("status",404);
        m1.put("Time stamp", System.currentTimeMillis());

        return m1;

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }

}
