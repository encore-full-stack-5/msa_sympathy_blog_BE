package com.example.user.dto.request;

import com.example.user.global.domain.entity.Neighbor;
import com.example.user.global.domain.entity.UserBlog;

import java.util.UUID;

public record NeighborRequest(
        String userBlogId,
        String type,
        Boolean status
)


{

    public Neighbor toEntity(){
        return Neighbor.builder()
                .type(type)
                .userBlog(UserBlog.builder().id(UUID.fromString(userBlogId)).build())
                .status(status)
                .build();
    }
}
