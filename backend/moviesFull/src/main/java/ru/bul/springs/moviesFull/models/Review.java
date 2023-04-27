package ru.bul.springs.moviesFull.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "body")
    private String body;

    @Column(name = "created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @Column(name = "updated")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated;

    @ManyToOne
    @JoinColumn(name = "movieid",referencedColumnName = "imdbid")
    private Movie movieid;

    public Review() {
    }

    public Review(String body, LocalDate created, LocalDate updated, Movie movieid) {
        this.body = body;
        this.created = created;
        this.updated = updated;
        this.movieid = movieid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    @Override
    public String toString() {
        return "Review{" +
                "body='" + body + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
