package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.*;
import com.example.dmd_damn_delicious.service.RatingService;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingControllerRest {

    private final RatingService ratingService;
    private final RecipeService recipeService;
    private final UserService userService;
    @Autowired
    public RatingControllerRest(RatingService ratingService, RecipeService recipeService, UserService userService) {
        this.ratingService = ratingService;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @PostMapping("/ratings/{recipeId}/{userId}")
    public ResponseEntity<Rating> createRating(@PathVariable(value = "userId") long userId, @PathVariable(value = "recipeId") long recipeId , @RequestBody Rating rating) {
        try {

            User user = userService.getUserByID(userId);
            Recipe recipe = recipeService.getRecipeById(recipeId);

            System.out.println(recipe.getId());

            Rating rating1 = ratingService.saveRating(new Rating(recipe, user, rating.getRating()));
            return new ResponseEntity<>(rating1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        try {
            List<Rating> ratings = ratingService.getAllRatings();

            if(ratings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ratings/r/{recipeId}")
    public ResponseEntity<List<Rating>> GetAllRatingsByRecipeId(@PathVariable(value = "recipeId") long recipeId) {

        List<Rating> ratings = ratingService.getAllRatingsByRecipeId(recipeId);

        if(ratings.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/ratings/{recipeId}/{userId}")
    public ResponseEntity<Rating> GetRatingByRecipeIdAndUserId(@PathVariable(value = "recipeId") long recipeId , @PathVariable(value = "userId") long userId) {

        Rating rating = ratingService.getRatingByRecipeIdAndUserId(recipeId, userId);

        if(rating == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping("/ratings/{id}")
    public ResponseEntity<Rating> GetAllRatingsById(@PathVariable(value = "id") long id) {

        Rating rating = ratingService.getRatingById(id).orElse(null);

        if(rating == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @PutMapping("/ratings/{id}")
    public ResponseEntity<Rating> updateRatingById(@PathVariable("id") long id, @RequestBody Rating rating) {
        Rating rating1 = ratingService.getRatingById(id).orElse(null);
        if(rating != null ) {
            rating1.setRating(rating.getRating());
            return new ResponseEntity<>(ratingService.saveRating(rating1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/ratings/{id}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable("id") long id){
        try {
            ratingService.deleteRatingById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
