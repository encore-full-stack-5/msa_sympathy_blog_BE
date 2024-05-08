package com.example.post.service;

import com.example.post.dto.request.PostViewRequest;
import com.example.post.global.domain.entity.PostView;
import com.example.post.global.domain.repository.PostViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostViewServiceImpl implements PostViewService {
    private final PostViewRepository postViewRepository;

    @Override
    public PostView update(PostViewRequest req, Long id) {
        PostView postView = postViewRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        postView.setView(postView.getView()+1);
        return postView;
    }

    @Override
    public Integer getPostViewByPostId(Long postId) {
        return postViewRepository.findPostViewByPostId(postId);
    }
}
