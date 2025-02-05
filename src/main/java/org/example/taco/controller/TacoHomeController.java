package org.example.taco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TacoHomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
