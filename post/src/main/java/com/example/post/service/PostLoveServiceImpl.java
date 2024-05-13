package com.example.post.service;

import com.example.post.dto.response.LoveResponse;
import com.example.post.exception.NoLoverException;
import com.example.post.exception.PostLoveNotFoundException;
import com.example.post.global.domain.entity.Post;
import com.example.post.global.domain.entity.PostLove;
import com.example.post.global.domain.entity.UserBlog;
import com.example.post.global.domain.repository.PostLoveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostLoveServiceImpl implements PostLoveService {

    private final PostLoveRepository postLoveRepository;

    // post를 생성하면 바로 새로운 like entity를 만들어준다. (like = false로 해서)

    @Override
    public Long countLove(Post post) {
        return postLoveRepository.countByPostIdAndLove(post.getId(), true).orElseGet(() -> 0L);
    }

    @Override
    @Transactional
    public void updateLove(Post post, UserBlog userBlog) {
        PostLove postLove = postLoveRepository
                .findByPostIdAndUserBlogId(post.getId(), userBlog.getId())
                .orElseThrow(PostLoveNotFoundException::new);
        postLove.setLove(!postLove.isLove());
        // click하고 love true/false는 front 에서 알아서 바꿈
    }

    @Override
    public List<LoveResponse> getLovers(Post post) {
        List<PostLove> postLoves = postLoveRepository.findByPostIdAndLove(post.getId(), true);
        if (postLoves.isEmpty()) throw new NoLoverException(); // front에서 null이면 없음을 보여줌
        List<LoveResponse> list = new ArrayList<>();
        postLoves.forEach((el) -> {
            LoveResponse loveResponse = new LoveResponse(el.getUserBlog().getNickname(), el.getPost().getTitle());
            list.add(loveResponse);
        });
        return list;
    }
}
