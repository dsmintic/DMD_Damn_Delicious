package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RatingService {

    Rating saveRating (Rating rating);

    void deleteRatingById (long id);

    Optional<Rating> getRatingById (long id);

    List<Rating> getAllRatings();

    List<Rating> getAllRatingsByRecipeId(long recipeId);

    Rating getRatingByRecipeIdAndUserId(long recipeId, long userId);
}
