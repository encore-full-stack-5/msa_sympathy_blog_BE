package com.example.post.dto.request;

import com.example.post.config.TokenInfo;
import com.example.post.global.domain.entity.Post;

public record PostRequest(
        String title,
        String content,
        Long userId
) {
    public Post toEntity(TokenInfo tokenInfo) {
        return Post.builder()
                .title(title)
                .content(content)
                .userId(tokenInfo.id())
                .build();
    }
}
