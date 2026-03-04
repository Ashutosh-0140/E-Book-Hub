package com.example.BookStore.service;


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

    @Autowired
    private Book_repo b1;

    public Book_Service(Book_repo b1){
        this.b1 = b1;
    }

    public Books getBook(Long Id) {
        return b1.findById(Id).orElseThrow(()->new bookNotFound("Book not found with id"+id));
    }
    public Books addBook(Books book){
        return b1.save(book);
    }

    public void deleteBook(Long id){
        b1.deleteById(id);
    }

    public List<Books> getAllBook(Books book){
        return b1.findAll();
    }

    public Books updateBook(Long Id, Books book){
        Books ExistingBook = b1.findById(Id).orElseThrow(()->new bookNotFound("Book not found with id"+id));

        ExistingBook.setBName(book.getBName());
        ExistingBook.setAuthor_name(book.getAuthor_name());
        ExistingBook.setPrice(book.getPrice());
        ExistingBook.setStock(book.getStock());

        return b1.save(ExistingBook);
    }
    public List<Books> SearchBook(String bookName){
        return b1.findBybNameContainingIgnoreCase(bookName);
    }
}
