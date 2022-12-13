package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Comment;
import com.example.dmd_damn_delicious.service.CommentService;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentControllerRest {

    private CommentService commentService;
    private UserService userService;
    private RecipeService recipeService;

    @Autowired
    public CommentControllerRest(CommentService commentService, UserService userService, RecipeService recipeService) {
        this.commentService = commentService;
        this.userService = userService;
        this.recipeService = recipeService;
    }


    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        try {
            Comment comment1 = commentService.saveComment(new Comment(comment.getText()));
            return new ResponseEntity<>(comment1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

