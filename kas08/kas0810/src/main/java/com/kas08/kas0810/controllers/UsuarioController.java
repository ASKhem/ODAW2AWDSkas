package com.kas08.kas0810.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "usuario/usuarioList";
    }

    @GetMapping("/new")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuarioForm";
    }

    @PostMapping("/new/submit")
    public String crearUsuario(Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/edit/{id}")
    public String editarUsuario(@PathVariable long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        model.addAttribute("usuario", usuario);
        return "usuario/UsuarioEditView";
    }

    @PostMapping("/edit/submit")
    public String actualizarUsuario(Usuario usuario) {
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}