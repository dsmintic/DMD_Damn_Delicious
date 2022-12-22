package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Ingredient;
import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.service.FileService;
import com.example.dmd_damn_delicious.service.IngredientsService;
import com.example.dmd_damn_delicious.service.RecipeService;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dmd_damn_delicious.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class RecipeControllerRest {
    private final RecipeService recipeService;
    private final UserService userService;

    private final IngredientsService ingredientsService;
    private final FileService fileService;

    @Value("${project.image}")
    private String path;

    @Autowired
    public RecipeControllerRest(RecipeService recipeService, UserService userService, IngredientsService ingredientsService, FileService fileService) {
        this.recipeService = recipeService;
        this.userService = userService;
        this.ingredientsService = ingredientsService;
        this.fileService = fileService;
    }

    @PostMapping("/recipes/{userId}")
    public ResponseEntity<Recipe> createRecipe (@PathVariable(value = "userId") long userId , @RequestBody Recipe recipe){

        try {
            User user = userService.getUserByID(userId);

            Set<Ingredient> ingredients = recipe.getIngredients();
            Set<Ingredient> ingredients1 = new HashSet<>();

            for(Ingredient ingredient : ingredients){
               ingredients1.add(ingredientsService.getIngredientById(ingredient.getId()));
            }

            Recipe recipe1 = recipeService.saveRecipe(new Recipe(recipe.getTitle(), recipe.getSummary(), recipe.getContent(), recipe.getImagePath(), user, ingredients1));
            return new ResponseEntity<>(recipe1 ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(value = "id") long id){
        Recipe recipe = recipeService.getRecipeById(id);

        if(recipe == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping("/recipes")
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

    @PutMapping("/recipes/{id}")
    public ResponseEntity<Recipe> updateRecipeById(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        Recipe recipe1 = recipeService.getRecipeById(id);
        if(recipe1 != null ) {
            recipe1.setTitle(recipe.getTitle());
            recipe1.setSummary(recipe.getSummary());
            recipe1.setContent(recipe.getContent());
            recipe1.setUpdateDate(LocalDateTime.now());

            Set<Ingredient> ingredients = new HashSet<>();
            for (Ingredient ingredient : recipe.getIngredients()){
                ingredients.add(ingredientsService.getIngredientById(ingredient.getId()));
            }
            recipe1.setIngredients(ingredients);

            if (!recipe.getImagePath().equals("empty")) {
                recipe1.setImagePath(recipe.getImagePath());
            }

        return new ResponseEntity<>(recipeService.saveRecipe(recipe1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/recipes/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe (@PathVariable("id") long id){
        try {
            recipeService.deleteRecipeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/recipes/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("image") MultipartFile image) {
        String imagePath = null;
        try {
            imagePath = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            return new ResponseEntity<>(imagePath, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        imagePath = imagePath.replace("frontendVue/src", "/src");

        return new ResponseEntity<>(imagePath, HttpStatus.OK);
    }
}
