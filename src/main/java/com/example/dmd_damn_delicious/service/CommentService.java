package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CommentService {

    Comment saveComment(Comment comment);
    void deleteCommentById (long id);
    Optional<Comment> getById(long id);

    List<Comment> getAllComments();
    List<Comment> getAllCommentsByRecipeId(long id);

    Comment getCommentById(long id);

    List<Comment> getAllCommentsByUserId(long userId);
}
