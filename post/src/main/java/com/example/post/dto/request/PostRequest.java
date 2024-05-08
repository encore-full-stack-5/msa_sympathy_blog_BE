package com.example.post.dto.request;

import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.type.PublicScope_buja;
import com.example.post.global.domain.type.Topic;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostRequest(
//        postPublicScope, topic -> enum
//        userId -> UUID 사용 예정,
//        추후 카테고리 추가 예정
        String title,
        String content,
        UUID userId,
        String nickname,
        String topic,
        String publicScope
) {
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .userBlog(UserBlog.builder()
                        .id(userId)
                        .nickname(nickname).build())
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope_buja.valueOf(publicScope))
                .topic(Topic.valueOf(topic))
                .build();
    }
}
