package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.Ingredient;
import com.example.dmd_damn_delicious.service.FileService;
import com.example.dmd_damn_delicious.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientsControllerRest {

    private final IngredientsService ingredientsService;
    private final FileService fileService;

    @Value("${project.image}")
    private String path;
    @Autowired
    public IngredientsControllerRest(IngredientsService ingredientsService, FileService fileService) {
        this.ingredientsService = ingredientsService;
        this.fileService = fileService;
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ingredients/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("image")MultipartFile image) {
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            return new ResponseEntity<>(fileName, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String proba = path + fileName;
        proba = proba.replace("frontendVue/src", "..");
        System.out.println(proba);
        return new ResponseEntity<>(fileName, HttpStatus.OK);
    }

}
