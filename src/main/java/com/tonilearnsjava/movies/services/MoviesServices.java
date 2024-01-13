package com.tonilearnsjava.movies.services;

import com.tonilearnsjava.movies.models.Movies;
import com.tonilearnsjava.movies.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesServices {

    private final MovieRepository movieRepository;
    public List<Movies> getAll(){
        return movieRepository.findAll();
    }

    public Optional<Movies> findMoviesByImdbID(String imdbId){
        return movieRepository.findMoviesByImdbId(imdbId);
    }
}
