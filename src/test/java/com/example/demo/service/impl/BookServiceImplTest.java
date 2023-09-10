package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Genre;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    private static final String LETTER = "M";
    private static final String FIRST_BOOK_NAME = "Money";
    private static final String SECOND_BOOK_NAME = "HarryPotter";
    private static final String FIRST_GENRE_NAME = "Horror";
    private static final String SECOND_GENRE_NAME = "Magic";
    private static final Long BOOK_ID = 1L;
    private Book firstBook;
    private Book secondBook;

    @InjectMocks
    private BookServiceImpl service;

    @Mock
    private BookRepository repository;


    @BeforeEach
    public void setUp() {

        firstBook = new Book(1L, FIRST_BOOK_NAME, new Genre(1L, FIRST_GENRE_NAME, List.of(new Book())), List.of(new Author(), new Author()));
        secondBook = new Book(2L, SECOND_BOOK_NAME, new Genre(2L, SECOND_GENRE_NAME, List.of(new Book())), List.of(new Author(), new Author()));

        lenient().when(repository.findById(BOOK_ID)).thenReturn(Optional.of(firstBook));
        lenient().when(repository.findAll()).thenReturn(List.of(firstBook, secondBook));
        lenient().when(repository.save(firstBook)).thenReturn(firstBook);
        lenient().when(repository.findAllByNameStartingWith(LETTER)).thenReturn(List.of(firstBook, secondBook));
        lenient().when(repository.findAllByOrderByName()).thenReturn(List.of(firstBook, secondBook));

    }

    @Test
    void getBookById() {
        Book book = service.getBookById(BOOK_ID);

        assertEquals(book.getId(), BOOK_ID);
    }

    @Test
    void createBook() {
        Book book = service.createBook(firstBook);

        assertEquals(firstBook, book);

        verify(repository).save(firstBook);
    }

    @Test
    void getAllBooksIsCorrect() {
        List<Book> result = service.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    void deleteBookById() {
        //todo
        service.deleteBookById(BOOK_ID);

        verify(repository).deleteById(BOOK_ID);
    }

    @Test
    void updateBook() {
        Book book = service.updateBook(firstBook);

        assertEquals(firstBook, book);

        verify(repository).save(firstBook);
    }

    @Test
    void getBooksOrderByName() {
        List<Book> result = service.getBooksOrderByName();

        assertEquals(FIRST_BOOK_NAME, result.get(0).getName());
        assertEquals(SECOND_BOOK_NAME, result.get(1).getName());
    }

    @Test
    void getBooksByLetterWhenOrderIsCorrect() {
        assertDoesNotThrow(() -> service.getBooksByLetter(LETTER));
        assertEquals(service.getBooksByLetter(LETTER), List.of(firstBook, secondBook));
    }

    @Test
    void getBooksByLetterWhenOrderIsIncorrect() {
        assertNotEquals(service.getBooksByLetter(LETTER), List.of(secondBook, firstBook));
    }
}