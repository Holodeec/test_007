package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.Genre;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/getAll/sort")
    public List<Book> getBooksSortByName() {
        return bookService.getBooksOrderByName();
    }

    @GetMapping("/getAll/{letter}")
    public List<Book> getBooksByLetter(@PathVariable String letter) {
        return bookService.getBooksByLetter(letter);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveBook(@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }


}
