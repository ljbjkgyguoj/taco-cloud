package org.example.taco.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.taco.dto.Ingredient;
import org.example.taco.dto.Taco;
import org.example.taco.dto.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/recipe")
@SessionAttributes("tacoOrder")
public class TacoRecipeController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Пшеничная тортилья", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Кукурузная тортилья", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Говядина", Ingredient.Type.PROTEIN),
                new Ingredient("CHIK", "Курица", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Томат", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Листья салата", Ingredient.Type.VEGGIES),
                new Ingredient("CHOR", "Кукуруза", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Монтерей Джек", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Сметанный соус", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showRecipeForm() {
        return "recipe";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "recipe";
        }

        tacoOrder.addTaco(taco);
        log.info("Тако добавлен в заказ: {}", taco);
        return "redirect:/orders/current";
    }
}

