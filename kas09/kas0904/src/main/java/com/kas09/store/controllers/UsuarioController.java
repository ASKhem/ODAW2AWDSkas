package com.kas09.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas09.store.domain.Usuario;
import com.kas09.store.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public String lista(Model model) {
        System.out.println("Los usuarios son:" + usuarioService.getUsuarios());
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "usuario/usuarioList";
    }

    @GetMapping("/new")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuarioForm";
    }

    @PostMapping("/new/submit")
    public String crearUsuario(@Valid Usuario usuario, Model model) {
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/list";
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
        return "redirect:/usuarios/list";
    }

    @GetMapping("/delete/{id}")
    public String borrarUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}