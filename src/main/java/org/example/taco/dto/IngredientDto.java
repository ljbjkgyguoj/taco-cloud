package org.example.taco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientDto {
    private String id;
    private String name;
    private IngredientType type;
}