package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Comment;
import com.example.dmd_damn_delicious.model.Recipe;
import com.example.dmd_damn_delicious.service.CommentService;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            Comment comment1 = commentService.saveComment(new Comment(comment.getText(), comment.getUser(), comment.getRecipe()));
            return new ResponseEntity<>(comment1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/comments"})
    public ResponseEntity<List<Comment>> getAllComments(){
        try {
            List<Comment> comments = commentService.getAllComments();

            if(comments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/comments/{id}"})
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") long id){
        Comment comment = commentService.getCommentById(id);

        if(comment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}") // PUT in REST API
    public ResponseEntity<Comment> updateCommentById(@PathVariable("id") long id, @RequestBody Comment comment) {
        Comment comment1 = commentService.getCommentById(id);
        if(comment1 != null ) {
            comment1.setText(comment.getText());
            return new ResponseEntity<>(commentService.saveComment(comment1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id){
        try {
            commentService.deleteCommentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

