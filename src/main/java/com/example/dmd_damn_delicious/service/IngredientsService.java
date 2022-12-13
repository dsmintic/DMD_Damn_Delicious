package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IngredientsService {

    void saveIngredient (Ingredient ingredient);

    void deleteIngredientById (long id);

    Optional<Ingredient> getById (long id);

}
