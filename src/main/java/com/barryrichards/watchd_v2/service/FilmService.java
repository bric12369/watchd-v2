package com.barryrichards.watchd_v2.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.barryrichards.watchd_v2.client.TmdbClient;
import com.barryrichards.watchd_v2.dto.TmdbFilmResult;
import com.barryrichards.watchd_v2.model.Film;
import com.barryrichards.watchd_v2.repository.FilmRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilmService {

    private FilmRepository filmRepository;
    private TmdbClient tmdbClient;
    
    public Film findById(UUID id) {
        return filmRepository.findById(id).orElse(null);
    }

    public Film findOrCreateByTmdbId(String tmdbId) {
        if (filmRepository.existsByTmdbId(tmdbId)) {
            return filmRepository.getByTmdbId(tmdbId).get();
        } else {
            TmdbFilmResult tmdbFilmResult = tmdbClient.getByTmdbId(tmdbId);
            String title = tmdbFilmResult.title();
            String posterUrl = tmdbFilmResult.posterPath();
            String synopsis = tmdbFilmResult.overview();
            LocalDate releaseDate = tmdbFilmResult.releaseDate();
            String tagline = tmdbFilmResult.tagline();
            String originalLanguage = tmdbFilmResult.originalLanguage();
            String originalTitle = tmdbFilmResult.originalTitle();
            int runtime = tmdbFilmResult.runtime();
            Film film = new Film(tmdbId, title, posterUrl, synopsis, releaseDate, tagline, originalLanguage, originalTitle, runtime);
            return filmRepository.save(film);
        }
    }
}
