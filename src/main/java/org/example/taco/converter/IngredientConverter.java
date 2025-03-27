package org.example.taco.converter;

import org.example.taco.dto.IngredientDto;
import org.example.taco.entity.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientConverter {

    Ingredient toEntity(IngredientDto ingredientDto);

    List<Ingredient> toEntityList(List<IngredientDto> ingredientDtoList);

    IngredientDto toDto(Ingredient ingredient);

    List<IngredientDto> toDtoList(List<Ingredient> ingredientList);
}
