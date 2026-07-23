package com.barryrichards.watchd_v2.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barryrichards.watchd_v2.model.Film;

public interface FilmRepository extends JpaRepository<Film, UUID> {
    
    Optional<Film> getByTmdbId(String tmdbId);
    List<Film> getAllByTitle(String title);

    boolean existsByTmdbId(String tmdbId);
}
