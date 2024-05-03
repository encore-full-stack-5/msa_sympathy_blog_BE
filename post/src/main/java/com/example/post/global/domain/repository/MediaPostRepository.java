package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.MediaPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPostRepository extends JpaRepository<MediaPost, Long> {
}
