package com.example.movieskiranataliemidlyn.Controllers;

import com.example.movieskiranataliemidlyn.Class.Movies;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movies", produces = "application/json")
public class MoviesController {
    List<Movies> movies =  new ArrayList<>();
    @GetMapping("")
        private List<Movies> allMovies() {

            movies.add(new Movies(1L,"meep","comedy","pg13","Midlyn"));
            return movies;
    }

    @PostMapping("")
        private void addAMovie(@RequestBody Movies newMovie) {
           movies.add(newMovie);
    }

    @DeleteMapping("/{id}")
        private void deleteMovie(@PathVariable Long id) {
        movies.remove(id);
    }


}
