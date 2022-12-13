package com.example.dmd_damn_delicious.service;


import com.example.dmd_damn_delicious.model.Rating;
import com.example.dmd_damn_delicious.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @Override
    public void saveRating(Rating rating) {
        this.ratingRepository.save(rating);

    }

    @Override
    public void deleteRatingById(long id) {
        this.ratingRepository.deleteById(id);
    }

    @Override
    public Optional<Rating> getById(long id) {
        return ratingRepository.findById(id);
    }
}
