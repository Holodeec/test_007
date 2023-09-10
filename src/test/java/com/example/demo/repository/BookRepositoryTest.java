package com.example.demo.repository;

import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertTrue;


@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testGetBookById() {
        Book testBook = new Book();
        testBook.setName("Example Book");

        bookRepository.save(testBook);
        Optional<Book> result = bookRepository.findById(testBook.getId());

        assertTrue(result.isPresent());
    }


}