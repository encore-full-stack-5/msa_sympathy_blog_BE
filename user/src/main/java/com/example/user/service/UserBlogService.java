package com.example.user.service;

import com.example.user.dto.response.SignInResponse;
import com.example.user.global.dto.UserBlogDto;

import java.util.UUID;

public interface UserBlogService {
    SignInResponse insertUser(UserBlogDto req);
    SignInResponse signIn(String token);
}
