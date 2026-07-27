package com.barryrichards.watchd_v2.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.barryrichards.watchd_v2.dto.TmdbFilmResult;
import com.barryrichards.watchd_v2.dto.TmdbSearchResponse;
import com.barryrichards.watchd_v2.exception.CustomException;

@Component
public class TmdbClient {

    private final RestClient restClient;

    public TmdbClient(@Value("${tmdb.api.base-url}") String baseUrl, @Value("${tmdb.api.read.access.token}") String readAccessToken) {
        restClient = RestClient.builder().baseUrl(baseUrl).defaultHeader("Authorization", "Bearer " + readAccessToken).build();
    }

    public TmdbSearchResponse searchByTitle(String title) {
        return restClient.get().uri("/search/movie?query={title}", title).retrieve().onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
            throw new CustomException("Film not found", "FILM_NOT_FOUND", HttpStatus.NOT_FOUND);
        }).body(TmdbSearchResponse.class);
    }

    public TmdbFilmResult getByTmdbId(String tmdbId) {
        return restClient.get().uri("/movie/" + tmdbId).retrieve().onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
            throw new CustomException("Film not found", "FILM_NOT_FOUND", HttpStatus.NOT_FOUND);
        }).body(TmdbFilmResult.class);
    }
}