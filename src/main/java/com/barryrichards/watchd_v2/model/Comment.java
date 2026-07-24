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
@Table(name = "comment")
@Getter @Setter @NoArgsConstructor
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_entry_id")
    private DiaryEntry diaryEntry;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Comment(DiaryEntry diaryEntry, Account account, String commentText) {
        this.diaryEntry = diaryEntry;
        this.account = account;
        this.commentText = commentText;
        createdAt = LocalDateTime.now();
    }

}
