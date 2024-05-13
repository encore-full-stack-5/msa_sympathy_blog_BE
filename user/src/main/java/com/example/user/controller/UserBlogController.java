package com.example.user.controller;

import com.example.user.dto.response.SignInResponse;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.service.TokenService;
import com.example.user.service.UserBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserBlogController {
    private final UserBlogService userBlogService;
    private final TokenService tokenService;

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestHeader("Authorization") String token){
//        UserBlogDto userInfoFromToken = tokenService.getUserInfoFromToken(token);
        return userBlogService.signIn(token);
    }



//    @GetMapping("/parse")
//    public String parseToken(@RequestParam(name = "token") String token) {
//        return userBlogService.parseToken(token);
//    }
}
