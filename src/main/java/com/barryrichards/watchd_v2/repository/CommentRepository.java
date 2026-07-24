package com.barryrichards.watchd_v2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barryrichards.watchd_v2.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    
}
