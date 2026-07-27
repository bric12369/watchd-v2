package com.barryrichards.watchd_v2.service;

import java.time.LocalDate;

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

    public Film findOrCreateByTmdbId(String tmdbId) {
        try {
            if (filmRepository.existsByTmdbId(tmdbId)) {
                return filmRepository.getByTmdbId(tmdbId).get();
            } else {
                TmdbFilmResult tmdbFilmResult = tmdbClient.getByTmdbId(tmdbId);
                String title = tmdbFilmResult.title();
                String posterUrl = tmdbFilmResult.posterPath();
                String synopsis = tmdbFilmResult.overview();
                LocalDate releaseDate = tmdbFilmResult.releaseDate();
                Film film = new Film(tmdbId, title, posterUrl, synopsis, releaseDate);
                return filmRepository.save(film);
            }
        } catch (Exception e) {
            System.out.println(">>>>>>>>>> " + e);
            return null;
        }
    }
}
