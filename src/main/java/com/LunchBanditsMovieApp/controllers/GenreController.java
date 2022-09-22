package com.LunchBanditsMovieApp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/genres", produces = "application/json")
public class GenreController {
    private GenreRepostiory genreRepository;

    @GetMapping("")
    privateList<genre> fetchAllGenre() {
        return genreRepository.findALL();
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
