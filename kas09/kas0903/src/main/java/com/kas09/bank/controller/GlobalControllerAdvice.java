package com.kas09.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kas09.bank.service.UserService;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addAttributes(Model model) {
        String username = userService.getCurrentUserName();
        model.addAttribute("username", username);
    }
}
