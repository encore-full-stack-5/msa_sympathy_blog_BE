package com.example.comment.service.d1;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;


    @Override
    public void saveComment(CommentRequest request) {
        commentRepository.save(request.toEntity());

    }

    @Override
    public void updateComment(CommentRequest request, Long id) {


    }



    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public boolean checkComment(Long id) {

        return false;
    }


}
