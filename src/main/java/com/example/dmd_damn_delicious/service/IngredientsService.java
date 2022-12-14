package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Ingredient;

import java.util.List;



public interface IngredientsService {

    Ingredient saveIngredient (Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    void deleteIngredientById (long id);

    Ingredient getIngredientById (long id);

}
