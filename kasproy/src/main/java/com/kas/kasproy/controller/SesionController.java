package com.kas.kasproy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SesionController {


    @GetMapping("/logout")
    public String getLogoutView() {
        return "sesion/logoutView";
    }

}
