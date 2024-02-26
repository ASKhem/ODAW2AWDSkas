package com.kas09.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kas09.store.domain.Usuario;
import com.kas09.store.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class LoginLogoutController {

    @Autowired
    UsuarioService usuarioService;

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

    @GetMapping("/registro/nuevo")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "public/registroView";
    }

    @PostMapping("/registro/nuevo/submit")
    public String registroSubmit(@Valid Usuario usuario) {
        System.out.println("Usuario: " + usuario);
        usuarioService.createUsuario(usuario);
        return "redirect:/public/index";
    }
}
