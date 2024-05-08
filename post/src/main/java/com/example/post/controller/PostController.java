package com.example.post.controller;

import com.example.post.dto.request.PostRequest;
import com.example.post.dto.response.PostResponse;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public void save(@RequestBody PostRequest req) {
        postService.save(req);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PostRequest req) {
        postService.update(req, id);
    }
    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    @GetMapping("/user/{userId}")
    public Page<PostResponse> getPostsByUserId(@PathVariable String userId,
                                               @PageableDefault(
                                                       page = 0,
                                                       size=5,
                                                       sort = "createdAt",
                                                       direction = Sort.Direction.DESC
                                               ) Pageable pageable) {
        return postService.getPostsByUserId(pageable,userId);
    }

}
