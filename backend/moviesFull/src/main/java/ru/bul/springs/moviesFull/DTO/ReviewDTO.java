package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReviewDTO {

    @NotEmpty
    private String body;


    public ReviewDTO() {
    }

    public ReviewDTO(String body) {
        this.body = body;


    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }




}
