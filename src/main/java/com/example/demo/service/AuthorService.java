package com.example.demo.service;

import com.example.demo.model.Author;

import java.util.List;


public interface AuthorService {

    Author getAuthorById(Long id) throws Exception;

    void createAuthor(Author author);

    List<Author> getAllAuthors();

    void deleteAuthorById(Long id);

    void updateAuthor(Author author);

}
