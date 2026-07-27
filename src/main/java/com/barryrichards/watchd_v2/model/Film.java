package com.barryrichards.watchd_v2.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film")
@Getter @Setter @NoArgsConstructor
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "tmdb_id")
    private String tmdbId;
    private String title;
    @Column(name = "poster_url")
    private String posterUrl;
    private String synopsis;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private String tagline;
    @Column(name = "original_language")
    private String originalLanguage;
    @Column(name = "original_title")
    private String originalTitle;
    private int runtime;

    public Film(String tmdbId, String title, String posterUrl, String synopsis, LocalDate releaseDate, String tagline, String originalLanguage, String originalTitle, int runtime) {
        this.tmdbId = tmdbId;
        this.title = title;
        this.posterUrl = posterUrl;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.tagline = tagline;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.runtime = runtime;
    }
}
