package com.example.BookStore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.BookStore.Exception.bookNotFound;
import com.example.BookStore.db.Books;
import com.example.BookStore.repository.Book_repo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.yaml.snakeyaml.events.Event;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class Book_Service {

    private final Book_repo b1;

    @Autowired
    public Book_Service(Book_repo b1) {
        this.b1 = b1;
    }

    public Books getBook(Long Id) {
        return b1.findById(Id)
                .orElseThrow(() -> new bookNotFound("Book not found with id " + Id));
    }

    public Books addBook(Books book) {
        return b1.save(book);
    }

    public void deleteBook(Long id) {
        b1.deleteById(id);
    }

    public List<Books> getAllBook() {
        return b1.findAll();
    }

    public Books updateBook(Long Id, Books book) {
        Books existingBook = b1.findById(Id)
                .orElseThrow(() -> new bookNotFound("Book not found with id " + Id));

        existingBook.setBName(book.getBName());
        existingBook.setAuthor_name(book.getAuthor_name());
        existingBook.setPrice(book.getPrice());
        existingBook.setStock(book.getStock());

        return b1.save(existingBook);
    }

    public List<Books> searchBook(String bookName) {
        return b1.findBybNameContainingIgnoreCase(bookName);
    }

    public Page<Books> getAllPage(Pageable pageable) {
        return b1.findAll(pageable); // ✅ fixed
    }
}