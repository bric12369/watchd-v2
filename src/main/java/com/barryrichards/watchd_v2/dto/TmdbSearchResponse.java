package com.barryrichards.watchd_v2.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TmdbSearchResponse(
        int page,
        List<TmdbFilmResult> results,
        @JsonProperty("total_pages") int totalPages,
        @JsonProperty("total_results") int totalResults) {
}
