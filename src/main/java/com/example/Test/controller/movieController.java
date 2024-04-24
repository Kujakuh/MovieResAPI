package com.example.Test.controller;

import com.example.Test.model.movie;
import com.example.Test.services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class movieController {
    @Autowired
    private movieService movieService;

    @GetMapping
    public List<movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public movie getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public movie addMovie(@RequestBody movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public movie updateMovie(@PathVariable Long id, @RequestBody movie
            movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}


