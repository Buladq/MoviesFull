package ru.bul.springs.moviesFull.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.bul.springs.moviesFull.models.Backdrop;
import ru.bul.springs.moviesFull.models.Genre;
import ru.bul.springs.moviesFull.models.Review;

import java.time.LocalDate;
import java.util.List;
@Schema(description = "фильм DTO образец")
public class MovieDTO {

    private int id;

    @NotEmpty
    private String title;

    private LocalDate releasedate;

    @NotEmpty
    private String trailerlink;

    private String poster;

    private List<GenreDTO> genreList;

    private List<BackdropDTO> backdropList;

    private List<ReviewDTO> reviewList;

    public MovieDTO() {
    }

    public MovieDTO(int id, String title, LocalDate releasedate, String trailerlink, String poster, List<GenreDTO> genreList, List<BackdropDTO> backdropList, List<ReviewDTO> reviewList) {
        this.id = id;
        this.title = title;
        this.releasedate = releasedate;
        this.trailerlink = trailerlink;
        this.poster = poster;
        this.genreList = genreList;
        this.backdropList = backdropList;
        this.reviewList = reviewList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
