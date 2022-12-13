package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CommentService {

    void saveComment(Comment comment);
    void deleteCommentById (long id);
    void save(Comment comment);
    Optional<Comment> getById(Long id);

}
