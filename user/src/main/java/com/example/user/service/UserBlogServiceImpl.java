
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

import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl implements UserBlogService, UserDetailsService {
    public final UserBlogRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
    }


    @Override
    public UserBlogDto saveInfo(UserBlogDto req) {
        // 데이터베이스에 저장할 Entity 생성
        UserBlog userBlog = UserBlog.builder()
                .email(req.toEntity().getEmail())
                .nickname(req.toEntity().getNickname())
                .id(req.toEntity().getId())
                .build();

        // 데이터베이스에 저장
        UserBlog save = userRepository.save(userBlog);
        return UserBlogDto.from(save);
    }

}
