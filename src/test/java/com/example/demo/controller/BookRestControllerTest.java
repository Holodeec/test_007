package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Genre;
import com.example.demo.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc(printOnlyOnFailure = false)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookRestControllerTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private MockMvc mockMvc;


    @BeforeAll
    public void save() {

    }



    @Test
    void getBookById() throws Exception {

        mockMvc.perform(get("/book/get/{id}",1))
                .andExpect(status().isOk())
                .andExpect((content().contentType(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Harry Potter"));
    }


//    @Test
//    void getBooksSortByName() {
//    }
//
//    @Test
//    void getBooksByLetter() {
//    }
//
//    @Test
//    void getAllBooks() {
//    }
//
//    @Test
//    void saveBook() {
//    }
//
//    @Test
//    void updateBook() {
//    }
//
//    @Test
//    void deleteBook() {
//    }
}