package com.example.post.service;


import com.example.post.global.domain.entity.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageServiceImplTest {
    @Autowired
    private ImageService imageService;

    @Test
    void save() {
        //given
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