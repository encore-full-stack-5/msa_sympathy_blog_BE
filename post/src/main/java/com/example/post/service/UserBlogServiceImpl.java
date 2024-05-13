package com.example.post.service;

import com.example.post.global.domain.repository.UserBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl implements UserBlogService, UserDetailsService {
    public final UserBlogRepository userBlogRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userBlogRepository
                .findByNickname(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
