package com.johncarter.booksRender.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johncarter.booksRender.models.Book;
import com.johncarter.booksRender.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepo;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepo = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}