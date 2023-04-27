package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import ru.bul.springs.moviesFull.models.Movie;

import java.util.List;

public class GenreDTO {

    private String name;

    public GenreDTO(String name) {
        this.name = name;
    }

    public GenreDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
