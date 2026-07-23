package com.barryrichards.watchd_v2.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barryrichards.watchd_v2.model.Film;
import com.barryrichards.watchd_v2.service.FilmService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/film")
@AllArgsConstructor
public class FilmController {
    
    private FilmService filmService;

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable UUID id) {
        return filmService.findById(id);
    }
}
