package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.PostView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostViewRepository extends JpaRepository<PostView, Long> {
}
