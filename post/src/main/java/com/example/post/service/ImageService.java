package com.example.post.service;

import com.example.post.global.domain.entity.Image;


public interface ImageService {
    void save(Long post_id, String path);
    void delete(Long id);
    void update(Long id, String newPath);
    Image findOne(Long id);
}
