package com.example.post.service;

import com.example.post.global.domain.entity.Image;
import com.example.post.global.domain.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public void save(Long post_id, String path) {
        imageRepository.save(new Image(null, post_id, path));
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, String newPath) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));
        image.setPath(newPath);
    }

    @Override
    public Image findOne(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));
        return image;
    }
}
