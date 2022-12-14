package com.example.dmd_damn_delicious.service;


import com.example.dmd_damn_delicious.model.Rating;
import com.example.dmd_damn_delicious.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @Override
    public Rating saveRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public void deleteRatingById(long id) {
        this.ratingRepository.deleteById(id);
    }

    @Override
    public Optional<Rating> getRatingById(long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByRecipeId(long recipeId) {
        return ratingRepository.findAllRatingsByRecipeId(recipeId);
    }

    @Override
    public Rating getRatingByRecipeIdAndUserId(long recipeId, long userId) {
        return ratingRepository.findByRecipeIdAndUserId(recipeId, userId);
    }
}
