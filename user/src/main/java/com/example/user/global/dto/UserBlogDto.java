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
    public static UserBlogDto from(Map res){
        return new UserBlogDto(
                res.get("id").toString(),
                res.get("email").toString(),
                res.get("nickname").toString()
        );
    }
}
