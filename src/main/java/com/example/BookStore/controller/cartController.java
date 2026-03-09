package com.example.BookStore.controller;

import com.example.BookStore.db.Cart;
import com.example.BookStore.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class cartController {
    @Autowired
    private cartService service;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return service.addToCart(cart);
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        return service.removeFromCart(id);
    }

    @GetMapping("/user/{id}")
    public List<Cart> getAllCart(@PathVariable Long id) {
        return service.getUserCart(id);
    }
}