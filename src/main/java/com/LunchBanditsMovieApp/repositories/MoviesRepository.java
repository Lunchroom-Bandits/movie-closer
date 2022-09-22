package com.LunchBanditsMovieApp.repositories;

import com.LunchBanditsMovieApp.data.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
