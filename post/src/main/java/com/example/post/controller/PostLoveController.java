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

    @GetMapping("/count") // 페이지 새로고침할 때 전체 갯수 가져오기
    public Long countLove(@RequestBody Post post) {
        return postLoveService.countLove(post);
    }

    @PutMapping // 버튼 누르면 좋아요 변경하기
    public void updateLove(@RequestBody Post post, @RequestBody UserBlog userBlog) {
        postLoveService.updateLove(post, userBlog);
    }

    @GetMapping("/lovers") // 좋아요 누른 사람의 닉네임과 블로그 이름 가져오기
    public List<LoveResponse> getLovers(@RequestBody Post post) {
        return postLoveService.getLovers(post);
    }
}
