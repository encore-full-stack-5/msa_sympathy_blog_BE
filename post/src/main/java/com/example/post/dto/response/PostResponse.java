package com.example.post.dto.response;

import com.example.post.global.domain.entity.Post;

public record PostResponse(
        Long id, String title, Long userId
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(), post.getTitle(), post.getUserId()
        );
    }
}
