package com.kas.kasproy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.services.componente.ComponenteService;


@Controller
@RequestMapping("/public")
public class PublicController {
    @Autowired
    ComponenteService componenteService;

    @GetMapping({"/home", "index"})
    public String getHomeView(){
        return "public/homeView";
    }

    @GetMapping("/buildPc")
    public String getBuildPcView(Model model){
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
    
}
