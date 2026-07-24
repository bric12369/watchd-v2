package com.barryrichards.watchd_v2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barryrichards.watchd_v2.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, UUID> {
    
}
