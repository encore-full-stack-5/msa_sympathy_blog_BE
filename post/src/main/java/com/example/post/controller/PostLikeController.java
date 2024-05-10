package com.example.post.controller;

import com.example.post.dto.response.LikeResponse;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/postLikes")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @GetMapping("/count")
    public Long countLike(@RequestBody Post post) {
        return postLikeService.countLike(post);
    }

    @PutMapping
    public void updateLike(@RequestBody Post post, @RequestBody UserBlog user) {
        postLikeService.updateLike(post, user);
    }

    @GetMapping("/liker")
    public List<LikeResponse> getLiker(@RequestBody Post post) {
        return postLikeService.getLiker(post);
    }
}
