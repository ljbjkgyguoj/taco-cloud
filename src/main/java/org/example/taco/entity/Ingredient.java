package org.example.taco.entity;

import lombok.Data;
import org.example.taco.dto.IngredientType;

@Data
public class Ingredient {
    private String id;
    private String name;
    private IngredientType type;
}