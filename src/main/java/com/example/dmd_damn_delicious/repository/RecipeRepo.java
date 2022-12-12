package com.example.dmd_damn_delicious.repository;



import com.example.dmd_damn_delicious.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface RecipeRepository extends JpaRepository<Recipe, Long> {
        //List<Recipe> findByTitle(String title);
    }
