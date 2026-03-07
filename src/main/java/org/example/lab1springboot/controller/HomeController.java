package org.example.lab1springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        System.out.println("DEBUG: Home controller triggered");

        model.addAttribute("message", "Welcome to Thymeleaf!");
        model.addAttribute("currentDate", java.time.LocalDate.now());

        return "home";
    }
}
