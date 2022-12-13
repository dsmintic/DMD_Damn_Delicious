package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Recipe;
import com.example.dmd_damn_delicious.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class  RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);

    }

    @Override
    public Recipe getRecipeById (long id){
        return recipeRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteRecipeById(long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return this.recipeRepository.findAll();
    }
}