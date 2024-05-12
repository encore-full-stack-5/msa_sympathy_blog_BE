package com.example.post.service;

import com.example.post.global.domain.entity.Image;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.repository.ImageRepository;
import com.example.post.global.domain.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final PostRepository postRepository;

    @Override
    public void save(Long postId, String path) {
        Optional<Post> postById = postRepository.findById(postId);
        Post post = postById
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        imageRepository.save(Image.builder()
                .post(post)
                .path(path)
                .build());
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
    public Image findImage(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));
        return image;
    }
}
