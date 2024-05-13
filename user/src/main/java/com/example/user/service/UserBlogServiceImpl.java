
package com.example.user.service;

import com.example.user.dto.response.SignInResponse;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.UserBlogRepository;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.global.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl implements UserBlogService, UserDetailsService {
    public final UserBlogRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username+" not found"));
    }
    @Override
    public SignInResponse insertUser(UserBlogDto req) {
        boolean existsById = userRepository.existsById(UUID.fromString(req.id()));
        if(!existsById) userRepository.save(req.toEntity());
        String generatedToken = jwtUtil.generateToken(req);
        return SignInResponse.from(generatedToken);
    }

    @Override
    public SignInResponse signIn(String token) {
        UserBlog userBlog =
        return null;
    }
}
