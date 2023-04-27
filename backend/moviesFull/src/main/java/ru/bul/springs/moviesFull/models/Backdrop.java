package ru.bul.springs.moviesFull.models;

import jakarta.persistence.*;

@Entity
@Table(name = "backdrops")
public class Backdrop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "movieid",referencedColumnName = "imdbid")
    private Movie movieid;

    public Backdrop() {
    }

    public Backdrop(int id, String link, Movie movieid) {
        this.id = id;
        this.link = link;
        this.movieid = movieid;
    }

    public Backdrop(String link, Movie movieid) {
        this.link = link;
        this.movieid = movieid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    @Override
    public String toString() {
        return "link='" + link + '\'';
    }
}
