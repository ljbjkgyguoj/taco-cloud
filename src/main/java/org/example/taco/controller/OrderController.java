package org.example.taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.taco.dto.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@Slf4j
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("tacoOrder", new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus) {
        log.info("Заказ подтвержден: {}", tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
