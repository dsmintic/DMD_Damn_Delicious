package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.dmd_damn_delicious.model.Recipe;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeControllerRest {
    private RecipeService recipeService;
    private UserService userService;

    @Autowired
    public RecipeControllerRest(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> createRecipe (@RequestBody Recipe recipe){

        try {
            Recipe recipe1 = recipeService.saveRecipe(new Recipe(recipe.getTitle(), recipe.getSummary(), recipe.getContent(), recipe.getUser(), recipe.getIngredients()));
            return new ResponseEntity<>(recipe1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//
    @GetMapping({"/recipes/{id}", "/user/{id}/recipes"})
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(value = "id") long id){
        Recipe recipe = recipeService.getRecipeById(id);

        if(recipe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping({"/recipes"})
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        try {
            List<Recipe> recipes = recipeService.getAllRecipes();

            if(recipes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
    @PutMapping("/recipes/{id}") // PUT in REST API
    public ResponseEntity<Recipe> updateRecipeById(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.getRecipeById(id);
        if(recipe1 != null ) {
            recipe1.setTitle(recipe.getTitle());
            recipe1.setSummary(recipe.getSummary());
            recipe1.setContent(recipe.getContent());
            recipe1.setIngredients(recipe.getIngredients());
        return new ResponseEntity<>(recipeService.saveRecipe(recipe1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//
    @DeleteMapping ("/recipes/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") long id){
        try {
            recipeService.deleteRecipeById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
