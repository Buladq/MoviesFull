package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReviewDTO {

    private String body;

    private LocalDate created;

    private LocalDate updated;

    public ReviewDTO() {
    }

    public ReviewDTO(String body, LocalDate created, LocalDate updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
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
}
