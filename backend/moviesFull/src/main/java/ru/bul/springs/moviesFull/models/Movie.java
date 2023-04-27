package ru.bul.springs.moviesFull.models;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "imdbid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imdbid;

    @Column(name = "title")
    private String title;


    @Column(name = "releasedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedate;

    @Column(name = "trailerlink")
    private String trailerlink;

    @Column(name = "poster")
    private String poster;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_imdbid"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genreList;

    @OneToMany(mappedBy = "movieid")
    private List<Backdrop> backdropList;

    @OneToMany(mappedBy = "movieid")
    private List<Review> reviewList;

    public Movie() {
    }



    public Movie(int imdbid, String title, LocalDate releasedate, String trailerlink, String poster, List<Genre> genreList, List<Backdrop> backdropList, List<Review> reviewList) {
        this.imdbid = imdbid;
        this.title = title;
        this.releasedate = releasedate;
        this.trailerlink = trailerlink;
        this.poster = poster;
        this.genreList = genreList;
        this.backdropList = backdropList;
        this.reviewList = reviewList;
    }

    public int getImdbid() {
        return imdbid;
    }

    public void setImdbid(int imdbid) {
        this.imdbid = imdbid;
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

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Backdrop> getBackdropList() {
        return backdropList;
    }

    public void setBackdropList(List<Backdrop> backdropList) {
        this.backdropList = backdropList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imdbid=" + imdbid +
                ", title='" + title + '\'' +
                ", releasedate=" + releasedate +
                ", trailerlink='" + trailerlink + '\'' +
                ", poster='" + poster + '\'' +
                ", genreList=" + genreList +
                ", backdropList=" + backdropList +
                ", reviewList=" + reviewList +
                '}';
    }
}
