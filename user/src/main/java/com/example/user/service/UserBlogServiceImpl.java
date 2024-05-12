
package com.example.user.service;

import com.example.user.dto.request.SignInRequest;
import com.example.user.dto.request.SignUpRequest;
import com.example.user.dto.request.TeamRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.dto.response.TokenResponse;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.exception.ExistedUserException;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.UserBlogRepository;
import com.example.user.global.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl implements UserBlogService {
    public final UserBlogRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RestTemplate restTemplate;

    @Override
    public SignInResponse signIn(SignInRequest request) {
        Optional<UserBlog> byEmail = userRepository.findByEmail(request.email());
        if (byEmail.isEmpty()||
                !passwordEncoder.matches(request.password(), byEmail.get().getPassword())
        )   throw new ExistedUserException(request.email());
        String token = jwtUtil.generateToken(request.email());
        return SignInResponse.from(token);
    }

    @Override
    public TokenResponse passToken(String token) {
        TeamRequest request = new TeamRequest("김부자", "3345");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization" ,"jwt " + token);
        HttpEntity<TeamRequest> requestEntity = new HttpEntity<>(
                request,
                httpHeaders
        );

        UserBlogResponse res = restTemplate
                .postForEntity(
//                        "http://192.168.0.12:8080/api/v1/auth/token"
                        "http://localhost:8080/api/v1/auth/token"
                        ,requestEntity
                        ,UserBlogResponse.class
                ).getBody();
        return new TokenResponse(jwtUtil.generateToken(res.id()));
    }

    @Override
    public String parseToken(String token) {
        return jwtUtil.getByEmailFromTokenAndValidate(token);
    }
}
