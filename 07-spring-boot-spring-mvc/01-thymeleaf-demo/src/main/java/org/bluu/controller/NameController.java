package org.bluu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameController {

    @GetMapping("/form")
    public String sendForm(){
        return "form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "datedemo";
    }

}
