
package com.example.user.service;

import com.example.user.dto.request.UserBlogRequest;
import com.example.user.dto.response.UserBlogResponse;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.UserBlogRepository;
import com.example.user.global.dto.UserBlogDto;
import com.example.user.global.utils.JwtUtil;
import com.example.user.kafka.dto.KafkaPostDto;
import com.example.user.kafka.dto.KafkaStatus;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    @Override
    public UserBlog update(UserBlogRequest req, UUID id) {
        UserBlog userBlog = userRepository.findById(id).orElseThrow(
                EntityNotFoundException::new);
        userBlog.setNickname(req.nickname());
        userBlog.setBlogName(req.blogName());
        userRepository.save(userBlog);
        return userBlog;
    }

    public UserBlogResponse getUserBlogByid(UUID id) {
        UserBlogResponse blogResponse = UserBlogResponse
                .from(userRepository.findAllById(id)
                        .orElseThrow(EntityNotFoundException::new));
        return blogResponse;
    }

    @KafkaListener(topics = "post-topic", id = "user")
    @Transactional
    public void listen(KafkaStatus<KafkaPostDto> dto) {
        if (dto.status().equals("insert")) {
            UserBlog user = userRepository.findById(dto.data().userBlogId()).orElseThrow(EntityNotFoundException::new);
            user.setPostId(dto.data().id());
        }
    }

}
