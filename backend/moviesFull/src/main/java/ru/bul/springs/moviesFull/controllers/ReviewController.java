package ru.bul.springs.moviesFull.controllers;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.bul.springs.moviesFull.DTO.ReviewDTO;
import ru.bul.springs.moviesFull.models.Review;
import ru.bul.springs.moviesFull.service.ReviewService;
import ru.bul.springs.moviesFull.util.ReviewErrorResponse;
import ru.bul.springs.moviesFull.util.ReviewNotCreated;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    private final ModelMapper modelMapper;

    public ReviewController(ReviewService reviewService, ModelMapper modelMapper) {
        this.reviewService = reviewService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/createReviewTest")
    public ResponseEntity<HttpStatus> createReview(@RequestBody @Valid Map<String, String> json,
                                                   BindingResult bindingResult){
        System.out.println(json);
        if(bindingResult.hasErrors()){
            StringBuilder erMsg=new StringBuilder();
            List<FieldError> errorList=bindingResult.getFieldErrors();
            for (var i:
                 errorList) {
                erMsg.append(i.getField());
                erMsg.append("-").append(i.getDefaultMessage());
                erMsg.append(";");
                
            }

            throw new ReviewNotCreated(erMsg.toString());
        }
        reviewService.createReview(convertToReview(json.get("reviewDTO")), Integer.parseInt(json.get("idMovie")));

        return ResponseEntity.ok(HttpStatus.OK);


    }


    @ExceptionHandler
    private ResponseEntity<ReviewErrorResponse> handleException(ReviewNotCreated reviewNotCreated){
        ReviewErrorResponse reviewErrorResponse=new ReviewErrorResponse(
                reviewNotCreated.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(reviewErrorResponse,HttpStatus.BAD_REQUEST);
    }



    public Review convertToReview(String reviewDTObody){
        ReviewDTO reviewDTO1=new ReviewDTO(reviewDTObody);
        return modelMapper.map(reviewDTO1, Review.class);
    }
}
