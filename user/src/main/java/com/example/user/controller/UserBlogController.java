package com.example.user.controller;

import com.example.user.dto.request.SignInRequest;
import com.example.user.dto.request.SignUpRequest;
import com.example.user.dto.request.TeamRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.service.TokenService;
import com.example.user.service.UserBlogService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserBlogController {
    private final UserBlogService userBlogService;
    private final TokenService tokenService;
    @PostMapping("signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignUpRequest request) {
        userBlogService.insertUser(request);
    }
    @PostMapping("signin")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        return userBlogService.signIn(request);
    }
    @PostMapping("token")
    @RolesAllowed({"USER"})
    public UserBlogResponse getUserResponse(@RequestBody TeamRequest request
            , @AuthenticationPrincipal UserBlog user) {
        tokenService.isAuthenticatedTeam(request);
        return new UserBlogResponse(
                user.getId().toString(),
                user.getEmail(),
                user.getNickname()
        );
    }
}
