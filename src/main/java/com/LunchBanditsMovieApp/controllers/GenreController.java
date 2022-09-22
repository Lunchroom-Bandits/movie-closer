package com.LunchBanditsMovieApp.controllers;

import com.LunchBanditsMovieApp.data.Genre;
import com.LunchBanditsMovieApp.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/genres", produces = "application/json")
public class GenreController {
    private GenreRepository genreRepository;

    @GetMapping("")
    private List<Genre> fetchAllGenre() {
        return genreRepository.findAll();
    }

    @GetMapping("/search")
    private Genre fetchGenreByName(@RequestParam String genreName) {
        Genre genre = genreRepository.findByName(genreName);
        if(genre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found");
        }
        return genre;
    }
}
