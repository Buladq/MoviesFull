package ru.bul.springs.moviesFull.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bul.springs.moviesFull.DTO.BackdropDTO;
import ru.bul.springs.moviesFull.DTO.GenreDTO;
import ru.bul.springs.moviesFull.DTO.MovieDTO;
import ru.bul.springs.moviesFull.models.Backdrop;
import ru.bul.springs.moviesFull.models.Genre;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.service.BackdropService;
import ru.bul.springs.moviesFull.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TestCont {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    private final BackdropService backdropService;

    public TestCont(MovieService movieService, ModelMapper modelMapper, BackdropService backdropService) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
        this.backdropService = backdropService;
    }


    @GetMapping("/movies")
    public List<MovieDTO> allMovies(){

        return movieService.getAll().stream().map(this::convertToMovieDTO).collect(Collectors.toList());
    }


    public MovieDTO convertToMovieDTO(Movie movie){
        return modelMapper.map(movie,MovieDTO.class);
    }







}
