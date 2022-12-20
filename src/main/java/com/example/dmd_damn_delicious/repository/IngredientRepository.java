package com.example.dmd_damn_delicious.repository;

import com.example.dmd_damn_delicious.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository  extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findById(long id);

    List<Ingredient> findAllByOrderByName();

}
