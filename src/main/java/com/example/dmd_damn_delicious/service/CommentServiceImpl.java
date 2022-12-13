package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Comment;
import com.example.dmd_damn_delicious.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public void saveComment(Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getById(long id) {
        return commentRepository.findById(id);
    }
}
