package ru.bul.springs.moviesFull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bul.springs.moviesFull.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
