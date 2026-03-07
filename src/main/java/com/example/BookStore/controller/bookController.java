package com.example.BookStore.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.BookStore.db.Books;
import com.example.BookStore.service.Book_Service;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/{book}")
public class bookController {
    @Autowired
    private Book_Service service;

    @GetMapping("/{Id}")
    public Books getSingleBook(@PathVariable Long Id){
        return service.getBook(Id);
    }

    @PostMapping
    public ResponseEntity<Books> addBooks(@Valid @RequestBody Books book){
        Books saveBook = service.addBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> removeBook(@PathVariable Long Id){
        service.deleteBook(Id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public List<Books> showAllBook(Books book){
//        return service.getAllBook(book);
//    }

    @PostMapping("/{Id}")
    public Books renueBook(@PathVariable Long Id,@Valid @RequestBody Books book){
        return service.updateBook(Id, book);
    }

    @GetMapping
    public Page<Books> getAllPage(Pageable page){
        return service.getAllPage(page);
    }
}
