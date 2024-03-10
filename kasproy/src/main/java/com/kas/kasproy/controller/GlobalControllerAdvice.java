package com.kas.kasproy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.services.usuario.UsuarioService;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    private UsuarioService userService;

    @ModelAttribute
    public void addAttributes(Model model) {
        String username = userService.getCurrentUserName();
        model.addAttribute("username", username);
        String role = userService.getCurrentUserRole();
        System.out.println("role: " + role);
        model.addAttribute("role", role);
        Usuario usuario = userService.findUsarioByNombre(username);
        model.addAttribute("usuarioActivo", usuario);
        
    }
}
