package com.LunchBanditsMovieApp.repositories;

import com.LunchBanditsMovieApp.data.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
