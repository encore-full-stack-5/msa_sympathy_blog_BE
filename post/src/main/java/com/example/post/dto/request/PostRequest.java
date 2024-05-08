package com.example.post.dto.request;

import com.example.post.config.TokenInfo;
import com.example.post.global.domain.entity.Post;

public record PostRequest(
        String title,
        String content,
        Long userId
) {

}
