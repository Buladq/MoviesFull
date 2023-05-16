package ru.bul.springs.moviesFull.controllers;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bul.springs.moviesFull.DTO.MovieDTO;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apik")
@Hidden
public class TestCont {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    public TestCont(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/movies")
    public List<MovieDTO> allMovies(){
        return movieService.getAll().stream().map(this::convertToMovieDTO).collect(Collectors.toList());
    }

    @GetMapping("/movies/search")
    public List<MovieDTO> allMoviesStart(@RequestParam(value = "text",required = false)String text){
        return movieService.findByStartWith(text).stream().map(this::convertToMovieDTO).collect(Collectors.toList());
    }

    @GetMapping("/movie/{id}")
    public MovieDTO allMovies(@PathVariable("id")int id){
        if(movieService.getMovieById(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HTTP Status will be NOT FOUND (CODE 404)\n");
        }
        return convertToMovieDTO(movieService.getMovieById(id));
    }


    public MovieDTO convertToMovieDTO(Movie movie){
        return modelMapper.map(movie,MovieDTO.class);
    }







}
