package com.example.dmd_damn_delicious.repository;



import com.example.dmd_damn_delicious.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface RecipeRepository extends JpaRepository<Recipe, Long> {
        List<Recipe> findById(String title);


    //Optional<Recipe> findById(long id);


}
