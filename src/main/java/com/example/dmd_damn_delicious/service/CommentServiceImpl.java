package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Comment;
import com.example.dmd_damn_delicious.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Collection<Comment> getAllDesc() {
        return commentRepository.findAllByOrderByCreationDateDesc();
    }

    public Collection<Comment> getAllAsc() {
        return commentRepository.findAllByOrderByCreationDateAsc();
    }

    @Override
    public Comment saveComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        this.commentRepository.deleteById(id);
    }


    @Override
    public Optional<Comment> getById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByRecipeId(long id) {
        return commentRepository.findAllByRecipeId(id);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getAllCommentsByUserId(long userId) {
        return commentRepository.findAllByUserId(userId);
    }
}
