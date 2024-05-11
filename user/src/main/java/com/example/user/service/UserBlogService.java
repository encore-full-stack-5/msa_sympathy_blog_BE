package com.example.user.service;

import com.example.user.dto.request.SignInRequest;
import com.example.user.dto.request.SignUpRequest;
import com.example.user.dto.response.SignInResponse;

public interface UserBlogService {
    void insertUser(SignUpRequest request);
    SignInResponse signIn(SignInRequest request);
}
