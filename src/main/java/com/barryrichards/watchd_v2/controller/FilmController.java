package com.barryrichards.watchd_v2.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barryrichards.watchd_v2.client.TmdbClient;
import com.barryrichards.watchd_v2.dto.TmdbSearchResponse;
import com.barryrichards.watchd_v2.model.Film;
import com.barryrichards.watchd_v2.service.FilmService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/film")
@AllArgsConstructor
public class FilmController {
    
    private FilmService filmService;
    private TmdbClient tmdbClient;

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable UUID id) {
        return filmService.findById(id);
    }

    // @GetMapping("/search")
    // public TmdbSearchResponse getFilmByTitle(@RequestParam String title) {
    //     return tmdbClient.searchByTitle(title);
    // }

    @GetMapping("/search")
    public Film getFilmByTmdbId(@RequestParam String tmdbId) {
        return filmService.findOrCreateByTmdbId(tmdbId);
    }
}
