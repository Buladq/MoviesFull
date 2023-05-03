package ru.bul.springs.moviesFull.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bul.springs.moviesFull.DTO.MovieDTO;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    private final ModelMapper modelMapper;

    public MovieController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return new ResponseEntity<List<MovieDTO>>(movieService.getAll().stream().map(this::convertToMovieDTO).collect(Collectors.toList()),
        HttpStatus.OK);
    }


    public MovieDTO convertToMovieDTO(Movie movie){
        return modelMapper.map(movie,MovieDTO.class);
    }

    public Movie convertToMovie(MovieDTO movieDTO){
        return modelMapper.map(movieDTO,Movie.class);
    }
}
