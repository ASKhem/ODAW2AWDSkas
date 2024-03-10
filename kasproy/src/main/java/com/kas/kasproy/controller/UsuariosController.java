package com.kas.kasproy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kas.kasproy.dto.UsuarioEditDto;
import com.kas.kasproy.dto.UsuarioNewDto;
import com.kas.kasproy.errors.ValidationOrder;
import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.services.pedido.PedidoService;
import com.kas.kasproy.services.usuario.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/list")
    public String listUsuarios(@RequestParam(required = false) Integer error, @RequestParam(required = false) Integer success, Model model){
        if(error != null && error == 1){
            model.addAttribute("error", "No se puede eliminar el usuario porque tiene pedidos asociados");
        }else if(success != null && success == 1){
            model.addAttribute("success", "Usuario eliminado correctamente");
        }else if(error != null && error == 2){
            model.addAttribute("error", "El usuario tiene un email o nombre de usuario ya registrado");
        }else if(success != null && success == 2){
            model.addAttribute("success", "Usuario actualizado correctamente");
        }else if(success != null && success == 3){
            model.addAttribute("success", "Usuario creado correctamente");
        }
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "user/userListView";
    }
    
    @GetMapping("/new")
    public String newUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "user/userFormView";
    }

    @PostMapping("/new/submit")
    public String newUsuarioSubmit(@Validated(ValidationOrder.class) @ModelAttribute UsuarioNewDto usuarioDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("usuario", usuarioDto);
            model.addAttribute("org.springframework.validation.BindingResult.usuario", bindingResult);
            return "user/userFormView";
        }
        usuarioService.createUsuario(usuarioDto);
        return "redirect:/usuarios/list?success=3";
    }

    @GetMapping("/edit/{id}")
    public String editUsuario(Model model, @PathVariable Long id){
        model.addAttribute("usuario", usuarioService.findById(id));
        return "user/userEditFormView";
    }

    @PostMapping("/edit/submit")
    public String editUsuarioSubmit(@ModelAttribute UsuarioEditDto usuario){
        if(usuarioService.updateUsuario(usuario) == null){
            return "redirect:/usuarios/list?error=2";
        }
        return "redirect:/usuarios/list?success=2";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Long id){
        if(pedidoService.getPedidosByUsuarioId(id).size() > 0){
            return "redirect:/usuarios/list?error=1";
        }
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/list?success=1";
    }
}
