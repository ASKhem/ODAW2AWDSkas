package com.example.kas07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController{
    @GetMapping({"", "/", "/index"})
    public String showHome() {
        return "homeView";
    }
    
}
