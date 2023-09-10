package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<Void> saveAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.ok().build();
    }
}
