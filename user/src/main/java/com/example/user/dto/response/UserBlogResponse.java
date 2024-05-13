package com.example.user.dto.response;

import java.util.Map;

public record UserBlogResponse(
        String id,
        String email,
        String nickname
) {
    public static UserBlogResponse from(Map res){
        return new UserBlogResponse(
                res.get("id").toString(),
                res.get("email").toString(),
                res.get("nickname").toString()
        );
    }
}
