package com.example.dmd_damn_delicious.service;

import com.example.dmd_damn_delicious.model.Ingredient;
import com.example.dmd_damn_delicious.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredientById(long id) {
        this.ingredientRepository.deleteById(id);
    }

    @Override
    public Optional<Ingredient> getById(long id) {
        return ingredientRepository.findById(id);
    }
}
