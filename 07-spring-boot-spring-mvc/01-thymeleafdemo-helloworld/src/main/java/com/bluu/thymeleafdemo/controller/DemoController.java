package com.bluu.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/date")
    public String sayHello(Model model) {
        model.addAttribute("date", java.time.LocalDate.now());
        return "datedemo";
    }
}
