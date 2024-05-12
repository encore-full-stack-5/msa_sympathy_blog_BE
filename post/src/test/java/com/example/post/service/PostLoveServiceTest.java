package com.example.post.service;

import com.example.post.global.domain.entity.Category;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.CategoryRepository;
import com.example.post.global.domain.repository.PostRepository;
import com.example.post.global.domain.repository.UserBlogRepository;
import com.example.post.global.domain.type.PublicScope;
import com.example.post.global.domain.type.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostLoveServiceTest {

    @Autowired
    private PostLoveService postLoveService;

    @Autowired
    private UserBlogRepository userBlogRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void countLove() {
        UserBlog userBlog = userBlogRepository.findByNickname("wlshzz").get();
        Category category = categoryRepository.findById(5L).get();
        Post post = Post.builder()
                .title("title")
                .content("content")
                .userBlog(userBlog)
                .createdAt(LocalDateTime.now())
                .publicScope(PublicScope.ALL)
                .topic(Topic.valueOf("LIFESTYLE"))
                .category(category)
                .build();
        postRepository.save(post);

        Long count = postLoveService.countLove(post);

        assertEquals(0, count);

    }

    @Test
    void updateLove() {




    }

    @Test
    void getLovers() {
    }
}