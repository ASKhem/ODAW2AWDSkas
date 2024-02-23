package com.kas09.bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
    
    @GetMapping("/errorPage")
    public String getErrorPage() {
        return "errorPage";
    }

    @GetMapping("/signin")
    public String showLogin() { return "loginView"; }

    @GetMapping("/logout")
    public String showLogout() { return "signoutView"; }
    
}
