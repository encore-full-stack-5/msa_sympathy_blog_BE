package com.example.post.controller;

import com.example.post.dto.response.LoveResponse;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.service.PostLoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/postLikes")
public class PostLoveController {

    private final PostLoveService postLoveService;

    @GetMapping("/count")
    public Long countLike(@RequestBody Post post) {
        return postLoveService.countLike(post);
    }

    @PutMapping
    public void updateLike(@RequestBody Post post, @RequestBody UserBlog userBlog) {
        postLoveService.updateLike(post, userBlog);
    }

    @GetMapping("/lovers")
    public List<LoveResponse> getLovers(@RequestBody Post post) {
        return postLoveService.getLovers(post);
    }
}
