package com.barryrichards.watchd_v2.model;

import java.util.UUID;

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
@Table(name = "follow")
@Getter @Setter @NoArgsConstructor
public class Follow {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private Account accountFollower;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id")
    private Account accountFollowed;

    public Follow(Account accountFollower, Account accountFollowed) {
        this.accountFollower = accountFollower;
        this.accountFollowed = accountFollowed;
    }
}
