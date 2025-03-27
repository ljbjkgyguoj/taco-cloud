package org.example.taco.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    @NotNull
    @Size(min = 1, message = "Укажите наименование")
    private String name;

    @NotNull
    @Size(min = 1, message = "Необходимо выбрать хотя бы 1 ингредиент")
    private List<Ingredient> ingredients;
}
