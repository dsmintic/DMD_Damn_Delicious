package com.example.dmd_damn_delicious.repository;

import com.example.dmd_damn_delicious.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findById(long id);

    List<Rating> findAllRatingsByRecipeId(long recipeId);
    Rating findByRecipeIdAndUserId(long recipeId, long userId);
}
