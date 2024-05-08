package com.example.comment.dto.request;

import com.example.comment.global.domain.entity.Comment;

public record CommentRequest(
        Long postId,
        Long id,
        Long userId,
        String content,
        String nickname

) {
    public Comment toEntity(){
        return Comment.builder()
                .postId(postId)
                .userId(userId)
                .id(id)
                .content(content)
                .nickname(nickname)
                .build();
    }

}
