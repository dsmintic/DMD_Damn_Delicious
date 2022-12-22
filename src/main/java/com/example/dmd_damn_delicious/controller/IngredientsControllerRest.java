package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Ingredient;
import com.example.dmd_damn_delicious.service.IngredientsService;
import com.example.dmd_damn_delicious.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class IngredientsControllerRest {

    private final IngredientsService ingredientsService;
    private final RecipeService recipeService;

    @Autowired
    public IngredientsControllerRest(IngredientsService ingredientsService, RecipeService recipeService) {
        this.ingredientsService = ingredientsService;
        this.recipeService = recipeService;
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {

        try {
            Ingredient ingredient1 = ingredientsService.saveIngredient(new Ingredient(ingredient.getName()));
            return new ResponseEntity<>(ingredient1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        try {
            List<Ingredient> ingredients = ingredientsService.getAllIngredients();

            if(ingredients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") long id) {
        //method to return tutorial by id from database
        Ingredient ingredient = ingredientsService.getIngredientById(id);

        if(ingredient != null) {
            return new ResponseEntity<>(ingredient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ingredients/recipe/{id}")
    public ResponseEntity<Set<Ingredient>> getIngredientByRecipeId(@PathVariable("id") long id) {
        //method to return tutorial by id from database
        Set<Ingredient> ingredients = recipeService.getRecipeById(id).getIngredients();

        if(!ingredients.isEmpty()) {
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("id") long id, @RequestBody Ingredient ingredient) {
        Ingredient ingredient1 = ingredientsService.getIngredientById(id);
        if(ingredient1 != null ) {
            ingredient1.setName(ingredient.getName());
            return new ResponseEntity<>(ingredientsService.saveIngredient(ingredient1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/ingredients/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable("id") long id){
        try {
            ingredientsService.deleteIngredientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
