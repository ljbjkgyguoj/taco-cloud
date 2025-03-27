package org.example.taco.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.taco.converter.IngredientConverter;
import org.example.taco.dto.IngredientDto;
import org.example.taco.dto.IngredientType;
import org.example.taco.dto.TacoDto;
import org.example.taco.dto.TacoOrderDto;
import org.example.taco.entity.Ingredient;
import org.example.taco.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/recipe")
@SessionAttributes("tacoOrder")
public class TacoRecipeController {

    private IngredientRepository ingredientRepository;

    private IngredientConverter ingredientConverter;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<IngredientDto> ingredientDtos = ingredientConverter.toDtoList(ingredients);

        for (IngredientType type : IngredientType.values()) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredientDtos, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrderDto order() {
        return new TacoOrderDto();
    }

    @ModelAttribute(name = "taco")
    public TacoDto taco() {
        return new TacoDto();
    }

    @GetMapping
    public String showRecipeForm() {
        return "recipe";
    }

    private Iterable<IngredientDto> filterByType(
            List<IngredientDto> ingredients, IngredientType type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(@Valid TacoDto taco, Errors errors,
                              @ModelAttribute TacoOrderDto tacoOrder) {
        if (errors.hasErrors()) {
            return "recipe";
        }

        tacoOrder.addTaco(taco);
        log.info("Тако добавлен в заказ: {}", taco);
        return "redirect:/orders/current";
    }
}

