package ru.bul.springs.moviesFull.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bul.springs.moviesFull.DTO.ReviewDTO;
import ru.bul.springs.moviesFull.models.Review;
import ru.bul.springs.moviesFull.service.ReviewService;
import ru.bul.springs.moviesFull.util.ReviewErrorResponse;
import ru.bul.springs.moviesFull.util.ReviewNotCreated;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@Validated
@RequestMapping("/api/review")
@Tag(name ="Отзывы" ,description ="Работа со всеми отзывами" )
public class ReviewController {
    private final ReviewService reviewService;

    private final ModelMapper modelMapper;

    public ReviewController(ReviewService reviewService, ModelMapper modelMapper) {
        this.reviewService = reviewService;
        this.modelMapper = modelMapper;
    }

//    @PostMapping("/createReviewTest")
//    public ResponseEntity<HttpStatus> createReview(@RequestBody Map< @Valid ReviewDTO, String> json,
//                                                   BindingResult bindingResult){
//        System.out.println(json);
//        System.out.println(bindingResult.hasErrors());
//
//
//        if(bindingResult.hasErrors()){
//            StringBuilder erMsg=new StringBuilder();
//            List<FieldError> errorList=bindingResult.getFieldErrors();
//
//            for (var i:
//                 errorList) {
//                erMsg.append(i.getField());
//                erMsg.append("-").append(i.getDefaultMessage());
//                erMsg.append(";");
//
//            }
//
//            throw new ReviewNotCreated(erMsg.toString());
//        }
//        reviewService.createReview(convertToReview((ReviewDTO) json.keySet().toArray()[0]), Integer.parseInt((String) json.values().toArray()[0]));
//
//        return ResponseEntity.ok(HttpStatus.OK);
//
//
//    }


    @PostMapping("/createReviewTest")
    public ResponseEntity<HttpStatus> createReview(@RequestBody Map< @Valid ReviewDTO, String> json,
                                                   BindingResult bindingResult){
        
        reviewService.createReview(convertToReview((ReviewDTO) json.keySet().toArray()[0]), Integer.parseInt((String) json.values().toArray()[0]));

        return ResponseEntity.ok(HttpStatus.OK);


    }


    @ExceptionHandler
    private ResponseEntity<ReviewErrorResponse> handleException(ReviewNotCreated reviewNotCreated){ //исключение для создания review
        ReviewErrorResponse reviewErrorResponse=new ReviewErrorResponse(
                reviewNotCreated.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(reviewErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class) //исключения другое
    public ResponseEntity<ReviewErrorResponse> handleValidationException(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.joining("; "));

        ReviewErrorResponse reviewErrorResponse=new ReviewErrorResponse(
                message,
                System.currentTimeMillis()
        );
          return new ResponseEntity<>(reviewErrorResponse,HttpStatus.BAD_REQUEST);
    }


    public Review convertToReview(ReviewDTO reviewDTO){
        return modelMapper.map(reviewDTO, Review.class);
    }
}
