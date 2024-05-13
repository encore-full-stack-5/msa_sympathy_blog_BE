package com.example.user.global.dto;

import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.domain.entity.UserBlog;

import java.util.Map;
import java.util.UUID;

public record UserBlogDto(
        String id,
        String email,
        String nickname
) {
    public UserBlog toEntity(){
        return UserBlog.builder()
                .id(UUID.fromString(id))
                .email(email)
                .nickname(nickname)
                .build();
    }
    public static UserBlogDto from(UserBlog userBlog){
        return new UserBlogDto(
                userBlog.getId().toString(),
                userBlog.getEmail(),
                userBlog.getNickname()
        );
    }
}
