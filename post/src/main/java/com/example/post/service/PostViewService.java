package com.example.post.service;

import com.example.post.dto.request.PostViewRequest;
import com.example.post.global.domain.entity.PostView;

public interface PostViewService {
    PostView update(PostViewRequest req, Long id);
    Integer getPostViewByPostId(Long postId);
}
