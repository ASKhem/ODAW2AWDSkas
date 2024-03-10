package com.kas.kasproy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas.kasproy.model.product.Componente;
import com.kas.kasproy.services.componente.ComponenteService;

@Controller
@RequestMapping("/componentes")
public class ComponentesController {
    @Autowired
    ComponenteService componenteService;

    @GetMapping("/list/{categoria}/{page}")
    public String listComponentes(@PathVariable String categoria, @PathVariable Integer page, Model model) {
        int ultPag = 0;
        List<Componente> componentes;
        if (!categoria.equals("all")) {
            componentes = componenteService.getComponentesByCategoria(categoria);
            ultPag = componenteService.getNumPages(componentes) - 1;
        } else {
            componentes = componenteService.getComponentes();
            ultPag = componenteService.getNumPages(componentes) - 1;
            categoria = "all";
        }
        if (page == null || page < 0 || page > ultPag) page = 0;
        Integer pagSig = ultPag > page ? page + 1 : ultPag;
        Integer pagAnt = page > 0 ? page - 1 : 0;
        System.out.println(componentes);
        model.addAttribute("componentes", componenteService.getComponentesPaginados(page, componentes));
        model.addAttribute("pagSiguiente", pagSig);
        model.addAttribute("pagAnterior", pagAnt);
        model.addAttribute("pagFinal", ultPag);
        model.addAttribute("categoria", categoria);
        return "components/componentsListView";
    }

    @GetMapping("/new")
    public String newComponente(Model model) {
        model.addAttribute("componente", new Componente());
        return "components/componentsFormView";
    }

    @PostMapping("/new/submit")
    public String newComponenteSubmit(@ModelAttribute Componente componente) {
        componenteService.createComponente(componente);
        return "redirect:/componentes/list/"+componente.getCategoria()+"/0";
    }
}
