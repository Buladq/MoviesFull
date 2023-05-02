package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import ru.bul.springs.moviesFull.models.Backdrop;
import ru.bul.springs.moviesFull.models.Genre;
import ru.bul.springs.moviesFull.models.Review;

import java.time.LocalDate;
import java.util.List;

public class MovieDTO {

    private String title;

    private LocalDate releasedate;

    private String trailerlink;

    private String poster;

    private List<GenreDTO> genreList;

    private List<BackdropDTO> backdropList;

    private List<ReviewDTO> reviewList;

    public MovieDTO() {
    }

    public MovieDTO(String title, LocalDate releasedate, String trailerlink, String poster, List<GenreDTO> genreList, List<BackdropDTO> backdropList, List<ReviewDTO> reviewList) {
        this.title = title;
        this.releasedate = releasedate;
        this.trailerlink = trailerlink;
        this.poster = poster;
        this.genreList = genreList;
        this.backdropList = backdropList;
        this.reviewList = reviewList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    public String getTrailerlink() {
        return trailerlink;
    }

    public void setTrailerlink(String trailerlink) {
        this.trailerlink = trailerlink;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<GenreDTO> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<GenreDTO> genreList) {
        this.genreList = genreList;
    }

    public List<BackdropDTO> getBackdropList() {
        return backdropList;
    }

    public void setBackdropList(List<BackdropDTO> backdropList) {
        this.backdropList = backdropList;
    }

    public List<ReviewDTO> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewDTO> reviewList) {
        this.reviewList = reviewList;
    }
}