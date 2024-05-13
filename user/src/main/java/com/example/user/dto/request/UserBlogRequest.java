package com.example.user.dto.request;

import com.example.user.global.domain.entity.UserBlog;

import java.util.UUID;

public record UserBlogRequest(
        String id, String email, String nickname,
        String blogName
) {
    public UserBlog toEntity(){
        return UserBlog.builder()
                .id(UUID.fromString(id))
                .email(email)
                .nickname(nickname)
                .blogName(blogName)
                .build();
    }
}
