package com.barryrichards.watchd_v2.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.barryrichards.watchd_v2.dto.TmdbSearchResponse;

@Component
public class TmdbClient {

    private final RestClient restClient;

    public TmdbClient(@Value("${tmdb.api.base-url}") String baseUrl, @Value("${tmdb.api.read.access.token}") String readAccessToken) {
        restClient = RestClient.builder().baseUrl(baseUrl).defaultHeader("Authorization", "Bearer " + readAccessToken).build();
    }

    public TmdbSearchResponse searchByTitle(String title) {
        return restClient.get().uri("/search/movie?query={title}", title).retrieve().body(TmdbSearchResponse.class);
    }
}