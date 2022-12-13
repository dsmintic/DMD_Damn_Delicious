package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Rating;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RatingService {

    void saveRating (Rating rating);

    void deleteRatingById (long id);

    Optional<Rating> getById (long id);
}
