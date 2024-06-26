package com.example.user.service;

import com.example.user.dto.request.UserBlogRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.domain.entity.UserBlog;

import com.example.user.global.dto.UserBlogDto;
import com.example.user.kafka.dto.KafkaInitDto;

import java.util.UUID;

public interface UserBlogService {
    SignInResponse saveInfo(UserBlogDto req);
    UserBlog update(UserBlogRequest req, UUID id);
    UserBlogResponse getUserBlogById(UUID id);
    void init();
}
