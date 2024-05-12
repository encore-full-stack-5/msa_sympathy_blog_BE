package com.example.post.service;


import com.example.post.dto.request.PostRequest;
import com.example.post.global.domain.entity.Category;
import com.example.post.global.domain.entity.Image;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.UserBlogRepository;
import com.example.post.global.domain.type.PublicScope;
import com.netflix.discovery.converters.Auto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageServiceImplTest {
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserBlogRepository userBlogRepository;
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void save() {
        //given
        Optional<UserBlog> byNickname = userBlogRepository.findByNickname("wlshzz");
        UserBlog userBlog = byNickname.get();

        categoryService.create("Hi", userBlog.getId());

        Category category = categoryService.getOne(1L);

        PostRequest postRequest = new PostRequest("Diary"
                , "Was Fun"
                , userBlog.getId()
                , "wlshzz"
                , "LIFESTYLE"
                , PublicScope.ALL
                , category);

        postService.save(postRequest);


        imageService.save(1L, "C:\\Users\\Playdata\\Pictures\\Screenshots");
        //when
        Image image = imageService.findImage(1L);
        //then
        assertNotNull(image);
        assertEquals("C:\\Users\\Playdata\\Pictures\\Screenshots", image.getPath());
    }

    @Test
    void delete() {
        //given

        //when

        //then
    }

    @Test
    void update() {
        //given

        //when

        //then

    }

    @Test
    void findOne() {
        //given

        //when

        //then
    }
}