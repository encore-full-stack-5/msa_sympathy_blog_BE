package com.example.user.service;

import com.example.user.dto.response.SignInResponse;
import com.example.user.global.dto.UserBlogDto;

import java.util.UUID;

public interface UserBlogService {
    UserBlogDto saveInfo(UserBlogDto req);
}
