package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Ingredient;
import com.example.dmd_damn_delicious.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public void deleteIngredientById(long id) {
        this.ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient getIngredientById(long id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
