package com.example.post.global.domain.repository;

import com.example.post.global.domain.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<Long> countByPostId(Long postId);
    Optional<PostLike> findByPostIdAndUserId (Long postId, Long userId);
    List<PostLike> findByPostIdAndLike (Long postId, boolean like);
}
