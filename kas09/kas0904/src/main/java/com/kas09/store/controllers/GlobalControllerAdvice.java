package com.kas09.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kas09.store.services.UsuarioService;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    private UsuarioService userService;

    @ModelAttribute
    public void addAttributes(Model model) {
        String username = userService.getCurrentUserName();
        model.addAttribute("username", username);
    }
}
