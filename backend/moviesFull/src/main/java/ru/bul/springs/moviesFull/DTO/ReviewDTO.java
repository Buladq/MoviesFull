package ru.bul.springs.moviesFull.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReviewDTO {

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2,max = 30,message = "size from 2 to 30")
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
