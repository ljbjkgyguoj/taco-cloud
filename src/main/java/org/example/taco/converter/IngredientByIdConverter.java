package org.example.taco.converter;

import org.example.taco.dto.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Пшеничная тортилья", Ingredient.Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient("COTO", "Кукурузная тортилья", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient("GRBF", "Говядина", Ingredient.Type.PROTEIN));
        ingredientMap.put("CHIK",
                new Ingredient("CHIK", "Курица", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient("TMTO", "Томат", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient("LETC", "Листья салата", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHOR",
                new Ingredient("CHOR", "Кукуруза", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient("JACK", "Монтерей Джек", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient("SRCR", "Сметанный соус", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
