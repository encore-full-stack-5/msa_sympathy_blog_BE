package com.example.user.dto.request;

import com.example.user.global.domain.entity.Neighbor;

import java.util.UUID;

public record NeighborRequest(
        String userBlogId,
        String type,
        Boolean status
)


{
    public Neighbor toEntity(){
        return Neighbor.builder()
                .userBlog(UUID.fromString(userBlogId))
                .type(null)
                .status(status)
                .build();
    }
}
