package ru.bul.springs.moviesFull.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bul.springs.moviesFull.models.Review;
import ru.bul.springs.moviesFull.repository.ReviewRepository;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final MovieService movieService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.movieService = movieService;
    }

    @Transactional
    public void createReview(Review review,int id){
        review.setMovieid(movieService.getMovieById(id));
        moreDetailsReview(review);
        reviewRepository.save(review);

    }

    public void moreDetailsReview(Review review){
        review.setCreated(LocalDate.now());
        review.setUpdated(LocalDate.now());
    }




}
