package com.example.Test.controller;
import com.example.Test.model.movie;
import com.example.Test.services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class BControl {
    @Autowired
    private com.example.Test.services.movieService movieService;

    @RequestMapping("/")
    String hola() {
        return "index";
    }

    @RequestMapping("/add")
    String addmovie() {
        return "addMovie";
    }

    @RequestMapping("/delete")
    String deletemovie() {
        return "deleteMovie";
    }

    @RequestMapping("/edit")
    String editmovie() {
        return "editMovie";
    }

    @PostMapping("/add")
    String movieAdded(@RequestParam String movie_name, @RequestParam String url, Model model){
        movie m = new movie();
        m.setUrl(url);
        m.setMovieName(movie_name);
        movieService.addMovie(m);
        model.addAttribute("message", "La película '" + movie_name + "' ha sido añadida.");
        return "index";
    }

    @DeleteMapping("/delete")
    String deletedMovie(@RequestParam Long delete_id, Model model){
        movie temp = movieService.getMovieById(delete_id);
        if(temp != null) {
            movieService.deleteMovie(delete_id);
            model.addAttribute("message", "La película con indice: " + delete_id + " ha sido eliminada.");
        } else model.addAttribute("message", "El id especificado no corresponde con ninguna pelicula");
        return "index";
    }

    @PutMapping("/edit")
    String editMovie(@RequestParam Long delete_id, @RequestParam String movie_name, @RequestParam String url, Model model){
        movie temp = movieService.getMovieById(delete_id);
        if(temp != null) {
            if (!Objects.equals(url, "")) temp.setUrl(url);
            if (!Objects.equals(movie_name, "")) temp.setMovieName(movie_name);
            movieService.updateMovie(delete_id, temp);
            if(Objects.equals(movie_name, "") && !Objects.equals(url, ""))
                model.addAttribute("message", "Película: " + delete_id + " Actualizada a: \n " +
                    " Url: " + url);
            else if(Objects.equals(url, "") && !Objects.equals(movie_name, ""))
                model.addAttribute("message", "Película: " + delete_id + " Actualizada a: \n " +
                    "Name: " + movie_name);
            else if (Objects.equals(url, "") && Objects.equals(movie_name, ""))
                model.addAttribute("message", "No se ha modificado ningun valor de la pelicula");
            else
                model.addAttribute("message", "Película: " + delete_id + " Actualizada a: \n " +
                    "Name: " + movie_name + " Url: " + url);
        }
        else model.addAttribute("message", "El id especificado no " +
                "corresponde con ninguna pelicula");

        return "index";
    }
}
