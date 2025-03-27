package org.example.taco.repository;

import org.example.taco.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
