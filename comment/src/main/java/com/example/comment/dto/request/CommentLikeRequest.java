package com.example.comment.dto.request;

import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.entity.CommentLike;

import java.util.UUID;

public record CommentLikeRequest(
        Long commentId,
        UUID userId,
        boolean isLiked


) {
    public CommentLike toEntity(){
        return CommentLike.builder()
                .isLiked(isLiked)
                .userId(userId)
                .comment(Comment.builder().id(commentId).build())
                .build();
    }
}
