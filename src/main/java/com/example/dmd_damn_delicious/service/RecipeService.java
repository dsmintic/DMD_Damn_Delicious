package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public interface RecipeService {

    Recipe saveRecipe (Recipe recipe);

    Recipe getRecipeById(long id);


    void deleteRecipeById(long id);

    List<Recipe> getAllRecipes();

    List<Recipe> getAllRecipesByCreationDate();
}
