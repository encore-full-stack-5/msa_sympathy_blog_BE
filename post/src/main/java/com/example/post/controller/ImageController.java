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

    @PostMapping
    public void save(@PathVariable Long post_id, @RequestParam String path) {
        imageService.save(post_id, path);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        imageService.delete(id);
    }

    @PutMapping
    public void update(@RequestParam Long id, @RequestParam String newPath) {
        imageService.update(id, newPath);
    }

    @GetMapping
    public Image getOne(@RequestParam Long id) {
        return imageService.findOne(id);
    }
}
