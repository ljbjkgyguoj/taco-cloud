package org.example.taco.converter;

import org.example.taco.dto.IngredientDto;
import org.example.taco.entity.Ingredient;
import org.example.taco.repository.IngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, IngredientDto> {

    private IngredientRepository ingredientRepository;

    private IngredientConverter ingredientConverter;

    @Override
    public IngredientDto convert(String id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);

        return ingredientConverter.toDto(ingredient);
    }
}
