package com.example.comment.global.domain.repository;

import com.example.comment.global.domain.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<CommentLike, Long> {
}
