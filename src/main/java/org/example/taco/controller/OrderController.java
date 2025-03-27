package org.example.taco.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.taco.dto.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@Slf4j
public class OrderController {

    @GetMapping("/current")
    public String orderForm(@ModelAttribute TacoOrder tacoOrder) {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Заказ подтвержден: {}", tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
