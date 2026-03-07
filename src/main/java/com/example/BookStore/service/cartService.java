package com.example.BookStore.service;

import com.example.BookStore.db.Cart;
import com.example.BookStore.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartService {
    @Autowired
    private cartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public String removeFromCart(Long id) {
        cartRepository.deleteById(id);
        return "Removed Successfully";
    }
}