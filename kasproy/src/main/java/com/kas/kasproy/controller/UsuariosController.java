package com.kas.kasproy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas.kasproy.dto.UsuarioEditDto;
import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.services.usuario.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public String listUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "user/userListView";
    }
    
    @GetMapping("/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "user/userFormView";
    }

    @PostMapping("/new/submit")
    public String newUsuarioSubmit(@ModelAttribute Usuario usuario){
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @GetMapping("/edit/{id}")
    public String editUsuario(Model model, @PathVariable Long id){
        model.addAttribute("usuario", usuarioService.findById(id));
        return "user/userEditFormView";
    }

    @PostMapping("/edit/submit")
    public String editUsuarioSubmit(@ModelAttribute UsuarioEditDto usuario){
        usuarioService.updateUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/list";
    }
}
