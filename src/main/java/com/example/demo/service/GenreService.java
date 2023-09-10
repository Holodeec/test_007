package com.example.demo.service;

import com.example.demo.model.Genre;

import java.util.List;


public interface GenreService {

    void createGenre(Genre genre);

    List<Genre> getAllGenres();

    void deleteGenreById(Long id);

    void updateGenre(Genre genre);
}
