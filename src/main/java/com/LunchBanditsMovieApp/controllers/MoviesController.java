package com.LunchBanditsMovieApp.controllers;

import com.LunchBanditsMovieApp.data.Movies;
import com.LunchBanditsMovieApp.repositories.MoviesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movies", produces = "application/json")
public class MoviesController {
    private MoviesRepository moviesRepository;


    @GetMapping("")
        public List<Movies> allMovies() {
        List <Movies> movies=moviesRepository.findAll();
//            movies.add(new Movies(1L,"meep","comedy","pg13","Midlyn"));
            return movies;
    }
    @GetMapping("/{id}")
    public Optional<Movies> fetchMoviesById(@PathVariable long id) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id);
        if(optionalMovies.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post id " + id + "not found ");
        }
        return optionalMovies;
    }

    @PostMapping("")
        private void addAMovie(@RequestBody Movies newMovie) {
           moviesRepository.save(newMovie);
    }

    @DeleteMapping("/{id}")
        private void deleteMovie(@PathVariable Long id) {
        moviesRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateMovies(@RequestBody Movies updatedMovies, @PathVariable long id) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id);
        if (optionalMovies.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post " + id + " not found");
        }
        Movies originalPost = optionalMovies.get();

        updatedMovies.setId(id);
        moviesRepository.save(updatedMovies);
    }
    // copy any new field values FROM updatedPost TO originalPost
//        BeanUtils.copyProperties(updatedPost, originalPost, FieldHelper.getNullPropertyNames(updatedPost));


}

