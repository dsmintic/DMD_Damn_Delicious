package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Comment;
import com.example.dmd_damn_delicious.model.Recipe;
import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.service.CommentService;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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


    @PostMapping("/comments/{userId}/{recipeId}")
    public ResponseEntity<Comment> createComment(@PathVariable(value = "userId") long userId, @PathVariable(value = "recipeId") long recipeId , @RequestBody Comment comment) {
        try {

            User user = userService.getUserByID(userId);
            Recipe recipe = recipeService.getRecipeById(recipeId);

            Comment comment1 = commentService.saveComment(new Comment(comment.getText(), user, recipe));
            return new ResponseEntity<>(comment1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/comments")
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

    @GetMapping("/comments/r/{recipeId}")
    public ResponseEntity<List<Comment>> GetAllCommentsByRecipeId(@PathVariable(value = "recipeId") long recipeId) {

        List<Comment> comments = commentService.getAllCommentsByRecipeId(recipeId);

        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/u/{userId}")
    public ResponseEntity<List<Comment>> GetAllCommentsByUserId(@PathVariable(value = "userId") long userId) {

        List<Comment> comments = commentService.getAllCommentsByUserId(userId);

        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") long id){
        Comment comment = commentService.getCommentById(id);

        if(comment == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateCommentById(@PathVariable("id") long id, @RequestBody Comment comment) {
        Comment comment1 = commentService.getCommentById(id);
        if(comment1 != null ) {
            comment1.setText(comment.getText());
            comment1.setUpdateDate(LocalDateTime.now());
            return new ResponseEntity<>(commentService.saveComment(comment1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id){
        try {
            commentService.deleteCommentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

