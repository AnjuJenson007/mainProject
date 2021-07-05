package com.main.project.java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String viewHomePage() {
        return "welcome";
    }

    @GetMapping("/mainMenu")
    public String viewMenuPage() {
        return "menu";
    }
}
