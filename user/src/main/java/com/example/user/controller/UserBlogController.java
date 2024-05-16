package com.example.user.controller;

import com.example.user.dto.request.UserBlogRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.UserBlogRepository;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.service.TokenService;
import com.example.user.service.UserBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserBlogController {
    private final UserBlogService userBlogService;
    private final TokenService tokenService;
    private final UserBlogRepository userBlogRepository;

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestHeader("Authorization") String token) {
        UserBlogDto userInfoFromToken = tokenService.getUserInfoFromToken(token);
        return userBlogService.saveInfo(userInfoFromToken);
    }

    @PutMapping("/user/profile")
    public void update(@AuthenticationPrincipal UserBlog user,
                       @RequestBody UserBlogRequest req) {
//        System.out.println(user.getId() + " 0" + user.getUsername());
        userBlogService.update(req, user.getId());
    }

    @GetMapping("/user/home")
    public UserBlogResponse getUserBlogById(@AuthenticationPrincipal UserBlog user) {
        return userBlogService.getUserBlogById(user.getId());
    }
}
