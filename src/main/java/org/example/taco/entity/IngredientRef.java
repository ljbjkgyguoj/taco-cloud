package org.example.taco.entity;

import lombok.Data;

@Data
public class IngredientRef {

    private Long tacoId;

    private String ingredientId;
}
