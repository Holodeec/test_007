package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;


public interface BookService {

    Book getBookById(Long id);

    Book createBook(Book book);

    List<Book> getAllBooks();

    void deleteBookById(Long id);

    Book updateBook(Book book);

    List<Book> getBooksOrderByName();

    List<Book> getBooksByLetter(String letter);
}
