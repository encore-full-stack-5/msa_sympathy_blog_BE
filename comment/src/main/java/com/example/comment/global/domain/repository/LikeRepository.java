package com.example.comment.global.domain.repository;

import com.example.comment.global.domain.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
