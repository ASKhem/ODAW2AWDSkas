package com.kas09.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivateController {
    
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
