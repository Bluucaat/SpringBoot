package org.bluu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/date")
    public String greetUser(Model model) {
        model.addAttribute("date", java.time.LocalDate.now());
        return "datedemo";
    }

    @RequestMapping("/processForm2")
    public String greetUserAndStealHisData(HttpServletRequest request, Model model){

        String greeting = "Hello, " + request.getParameter("name").toUpperCase();
        model.addAttribute("greeting", greeting);

        return "datedemo";
    }

    @RequestMapping("/processForm3")
    public String greetUserAndStealHisDataMoreAdvanced(@RequestParam("name") String name, Model model){

        model.addAttribute("greeting", name.toUpperCase());
        return "datedemo";
    }
}
