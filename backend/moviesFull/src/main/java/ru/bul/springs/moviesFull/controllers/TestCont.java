package ru.bul.springs.moviesFull.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.repository.MovieRepository;
import ru.bul.springs.moviesFull.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCont {

    private final MovieService movieService;

    public TestCont(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String allMovies(){
        return movieService.getAll().get(0).getTitle();
    }

}
