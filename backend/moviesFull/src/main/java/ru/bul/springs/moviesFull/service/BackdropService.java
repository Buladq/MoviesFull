package ru.bul.springs.moviesFull.service;


import org.springframework.stereotype.Service;
import ru.bul.springs.moviesFull.models.Backdrop;
import ru.bul.springs.moviesFull.repository.BackdropRepository;

import java.util.List;

@Service
public class BackdropService {

    private final BackdropRepository backdropRepository;

    public BackdropService(BackdropRepository backdropRepository) {
        this.backdropRepository = backdropRepository;
    }

    public List<Backdrop> getAll(){
        return  backdropRepository.findAll();
    }
}
