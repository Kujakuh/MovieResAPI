package com.example.Test.services;

import com.example.Test.model.movie;
import com.example.Test.repos.movieRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class movieService {
    @Autowired
    private movieRepos movieRepository;
    public List<movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    public movie createMovie(movie movie) {
        return movieRepository.save(movie);
    }
    public movie addMovie(movie movie) {
        return movieRepository.save(movie);
    }
    public movie updateMovie(Long id, movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
