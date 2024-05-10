
package com.example.user.service;

import com.example.user.dto.request.SignInRequest;
import com.example.user.dto.request.SignUpRequest;
import com.example.user.dto.response.SignInResponse;
import com.example.user.exception.ExistedUserException;
import com.example.user.global.domain.entity.UserBlog;
import com.example.user.global.domain.repository.UserBlogRepository;
import com.example.user.global.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl implements UserBlogService, UserDetailsService {
    public final UserBlogRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public void insertUser(SignUpRequest request) {
        log.info("insert user");
//        1. 유저가 있는지 찾아보고
        Optional<UserBlog> byEmail = userRepository.findByEmail(request.email());
//        2-1. 없으면 에러
//        2-2. 없으면 인서트
        if (byEmail.isPresent()) {
            throw new ExistedUserException(request.email());
        }
        String encode = passwordEncoder.encode(request.password());
        log.info(request.toString());
        userRepository.save(request.toEntity(encode));
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        Optional<UserBlog> byEmail = userRepository.findByEmail(request.email());
//        if (byEmail.isPresent()) {
//            User user = byEmail.get();
//            if (!passwordEncoder.matches(request.password(), user.getPassword())) {
//                throw new IllegalArgumentException();
//            }
//        }

//        User user = byEmail.orElseThrow(IllegalArgumentException::new);
//        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
//                throw new IllegalArgumentException();
//            }
        if (byEmail.isEmpty()||
                !passwordEncoder.matches(request.password(), byEmail.get().getPassword())
        )   throw new ExistedUserException(request.email());
        String token = jwtUtil.generateToken(request.email());
        return SignInResponse.from(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
