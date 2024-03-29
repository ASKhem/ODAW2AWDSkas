package com.kas09.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas09.bank.model.Usuario;
import com.kas09.bank.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String getUsersList(Model model) {
        model.addAttribute("users", userService.getUsers());
        System.out.println(userService.findUserById(4L));
        return "userList";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user", new Usuario());
        return "newUser";
    }

    @PostMapping("/new/submit")
    public String createUserSubmit(@Valid Usuario user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Campos incorrectos. Por favor, rellene los campos correctamente.");
            return "newUser";
        }else{
            userService.createUser(user);
            return "redirect:/users/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

    @PostMapping("/edit/submit")
    public String editUserSubmit(@Valid Usuario user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "editUser";
        }
        userService.editUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

    
   
}
