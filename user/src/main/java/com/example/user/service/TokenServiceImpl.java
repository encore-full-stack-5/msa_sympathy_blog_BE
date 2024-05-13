package com.example.user.service;
import com.example.user.dto.request.TeamRequest;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.dto.UserBlogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{
    private final RestTemplate restTemplate;
    @Override
    public UserBlogResponse getUserInfoFromToken(String token) {
        TeamRequest request = new TeamRequest("김부자", "3345");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<TeamRequest> requestEntity = new HttpEntity<>(
                request,
                httpHeaders
        );
        httpHeaders.set("Authorization", token);

        UserBlogResponse res = restTemplate
                .postForEntity(
                        "http://localhost:8080/api/v1/auth/token"
                        , requestEntity
                        , Map.class
                ).getBody();

        return UserBlogDto.from(res);
    }
}