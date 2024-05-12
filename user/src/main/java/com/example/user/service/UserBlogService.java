package com.example.user.service;

import com.example.user.dto.request.SignInRequest;
import com.example.user.dto.request.SignUpRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.dto.response.TokenResponse;

import java.util.UUID;

public interface UserBlogService {
    SignInResponse signIn(SignInRequest request);
    TokenResponse passToken(String token);
    String parseToken(String token);
}
