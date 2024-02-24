package com.kas09.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

    @GetMapping("/errorPage")
    public String getErrorPage() {
        return "errorPage";
    }

    @GetMapping("/login")
    public String login() {
        return "public/loginView";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "signoutView";
    }
}
