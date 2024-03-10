package com.kas.kasproy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kas.kasproy.dto.UsuarioNewStandardDto;
import com.kas.kasproy.errors.ValidationOrder;

import jakarta.validation.Valid;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.services.componente.ComponenteService;
import com.kas.kasproy.services.usuario.UsuarioService;

@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    ComponenteService componenteService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping({ "/home", "index" })
    public String getHomeView() {
        return "public/homeView";
    }

    @GetMapping("/buildPc")
    public String getBuildPcView(Model model) {
        model.addAttribute("ordenador", new OrdenadorNewDto());
        model.addAttribute("procesadores", componenteService.getComponentesByCategoria("procesador"));
        model.addAttribute("placas", componenteService.getComponentesByCategoria("placa"));
        model.addAttribute("rams", componenteService.getComponentesByCategoria("ram"));
        model.addAttribute("almacenamientos", componenteService.getComponentesByCategoria("almacenamiento"));
        model.addAttribute("tarjetas", componenteService.getComponentesByCategoria("tarjeta"));
        model.addAttribute("fuentes", componenteService.getComponentesByCategoria("fuente"));
        model.addAttribute("cajas", componenteService.getComponentesByCategoria("caja"));
        return "public/buildPcFormView";
    }

    @GetMapping("/signup")
    public String getSignupView() {
        return "public/signupView";
    }

    @GetMapping("/register")
    public String getRegisterView(Model model) {
        model.addAttribute("usuario", new UsuarioNewStandardDto());
        return "public/registerView";
    }


    @PostMapping("/register/submit")
    public String postRegisterSubmit(@Validated(ValidationOrder.class) @ModelAttribute UsuarioNewStandardDto usuarioDto, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("usuario", usuarioDto);
            model.addAttribute("org.springframework.validation.BindingResult.usuario", bindingResult);
            return "public/registerView";
        }
    
        return "redirect:/public/home";
    }

}
