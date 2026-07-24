package com.barryrichards.watchd_v2.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diary_entry")
@Getter @Setter @NoArgsConstructor
public class DiaryEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;
    private double rating;
    @Column(name = "review_text")
    private String reviewText;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DiaryEntry(Account account, Film film, double rating) {
        this.account = account;
        this.film = film;
        this.rating = rating;
        createdAt = LocalDateTime.now();
    }

}
