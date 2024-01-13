package com.tonilearnsjava.movies.controllers;

import com.tonilearnsjava.movies.models.Movies;
import com.tonilearnsjava.movies.services.MoviesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MoviesServices moviesServices;
    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies(){
        return new ResponseEntity<>(moviesServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(moviesServices.findMoviesByImdbID(imdbId),HttpStatus.OK);
    }
}
