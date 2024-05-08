package com.example.comment.service.d1;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.global.domain.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    void saveComment(CommentRequest request);
    void updateComment(CommentRequest request,Long id);
    void deleteComment(Long id);
    boolean checkComment(Long id);

}
