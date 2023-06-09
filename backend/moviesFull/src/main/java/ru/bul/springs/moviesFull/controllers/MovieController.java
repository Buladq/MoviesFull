package ru.bul.springs.moviesFull.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bul.springs.moviesFull.DTO.MovieDTO;
import ru.bul.springs.moviesFull.DTO.ReviewDTO;
import ru.bul.springs.moviesFull.models.Movie;
import ru.bul.springs.moviesFull.models.Review;
import ru.bul.springs.moviesFull.service.MovieService;
import ru.bul.springs.moviesFull.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/movies")
@Tag(name = "Фильмы",description ="Операции со всеми фильмами" )
public class MovieController {

    private final MovieService movieService;

    private final ModelMapper modelMapper;


    public MovieController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    @Operation(summary = "Получение всех фильмов")
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return new ResponseEntity<List<MovieDTO>>(movieService.getAll().stream().map(this::convertToMovieDTO).collect(Collectors.toList()),
        HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "получение информации о фильме по id")
    public ResponseEntity<MovieDTO> getOneMovie(@PathVariable("id") int id){
        return new ResponseEntity<MovieDTO>(convertToMovieDTO(movieService.getMovieById(id)),HttpStatus.OK);
    }






    public MovieDTO convertToMovieDTO(Movie movie){
        return modelMapper.map(movie,MovieDTO.class);
    }

    public Movie convertToMovie(MovieDTO movieDTO){
        return modelMapper.map(movieDTO,Movie.class);
    }


}
