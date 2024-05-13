package com.example.user.service;

import com.example.user.dto.request.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserBlogServiceTest {
    @Autowired
    private UserBlogService authService;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void 통신1(){
//        SignUpRequest request = new SignUpRequest("buja@2.com", "1234", "r", LocalDate.now(), "남");
//        Map<String, Object> res= restTemplate
//                .postForEntity(
//                        "http://localhost:8080/api/v1/auth/signin"
//                        ,request
//                        , Map.class).getBody();
//        System.out.println(res);
    }
    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIwMTFmNzkzNy1hYzA4LTRkNmItOWNiMS0wYzhmNjYzOWNmOTciLCJleHAiOjE3MTUzMzU1MTh9.mDi4gU0c_rfj0KPyyDaZhfk-E0Qq300VfpiMk6biFDW95oDXQbMBW2g1LHc5aAeo";

        String email = authService.parseToken(token);

        assertNotNull(email);
        System.out.println(email);
    }
}