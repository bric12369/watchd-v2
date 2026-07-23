package com.barryrichards.watchd_v2.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.barryrichards.watchd_v2.model.Film;
import com.barryrichards.watchd_v2.repository.FilmRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilmService {

    private FilmRepository filmRepository;
    
    public Film findById(UUID id) {
        return filmRepository.findById(id).orElse(null);
    }
}
