package com.example.movieskiranataliemidlyn.Controllers;

import com.example.movieskiranataliemidlyn.Class.Movies;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movies", produces = "application/json")
public class MoviesController {

    @GetMapping("")
        private List<Movies> allMovies() {
            List<Movies> movies =  new ArrayList<>();
            movies.add(new Movies(1L,"meep","comedy","pg13","Midlyn"));
            return movies;
    }
}
