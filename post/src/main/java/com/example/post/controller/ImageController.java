package com.example.post.controller;

import com.example.post.global.domain.entity.Image;
import com.example.post.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/images")
@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/{postId}")
    public void save(@PathVariable Long postId, @RequestBody String path) {
        imageService.save(postId, path);
    }

    @DeleteMapping
    public void delete(@RequestBody Long id) {
        imageService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Long id, @RequestBody String newPath) {
        imageService.update(id, newPath);
    }

    @GetMapping
    public Image getOne(@RequestBody Long id) {
        return imageService.findImage(id);
    }
}
