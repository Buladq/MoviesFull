package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.*;
import ru.bul.springs.moviesFull.models.Movie;

public class BackdropDTO {

    private String link;

    public BackdropDTO() {
    }

    public BackdropDTO(String link) {
        this.link = link;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
