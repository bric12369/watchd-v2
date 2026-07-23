package com.barryrichards.watchd_v2.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TmdbFilmResult(
        long id,
        String title,
        String overview,
        @JsonProperty("poster_path") String posterPath,
        @JsonProperty("release_date") LocalDate releaseDate) {
}
