package com.example.user.controller;

import com.example.user.dto.request.UserBlogRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.kafka.dto.KafkaUserBlogDto;
import com.example.user.kafka.producer.UserBlogIdProducer;
import com.example.user.service.TokenService;
import com.example.user.service.UserBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserBlogController {
    private final UserBlogService userBlogService;
    private final TokenService tokenService;
    private final UserBlogIdProducer userBlogIdProducer;

    @PostMapping("/signIn")
    public UserBlogDto signIn(@RequestHeader("Authorization") String token){
        UserBlogDto userInfoFromToken = tokenService.getUserInfoFromToken(token);
        return userBlogService.saveInfo(userInfoFromToken);
    }

    @PutMapping("/{id}")
    public UserBlog update(@PathVariable UUID id, @RequestBody UserBlogRequest req) {
        userBlogService.update(req, id);
        KafkaUserBlogDto kafkaUserBlogDto = new KafkaUserBlogDto(id.toString(),req.nickname());
        userBlogIdProducer.send(kafkaUserBlogDto,"update");

    return null;
    }





//    @GetMapping("/parse")
//    public String parseToken(@RequestParam(name = "token") String token) {
//        return userBlogService.parseToken(token);
//    }
}
