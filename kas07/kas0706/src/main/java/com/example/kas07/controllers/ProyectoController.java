package com.example.kas07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kas07.domain.Proyecto;
import com.example.kas07.services.HelperService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
    
    @Autowired
    public HelperService <Proyecto> proyectoService;

    @GetMapping({"", "/list"})
    public String showList(Model model) {
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "proyecto/listView";  
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("proyectoForm", new Proyecto());
        return "proyecto/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Proyecto proyectoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/proyectos/new";
        proyectoService.añadir(proyectoForm);
        return "redirect:/proyectos/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Long id) {
        proyectoService.borrar(id);
        return "redirect:/proyectos/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Proyecto proyecto = proyectoService.obtenerPorId(id);
        if (proyecto != null) {
            model.addAttribute("proyectoForm", proyecto);
            return "proyecto/editFormView";
        } else {
            return "redirect:/proyectos/list";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Proyecto proyectoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/proyectos/edit/" + proyectoForm.getId();
        proyectoService.editar(proyectoForm);
        return "redirect:/proyectos/list";
    }
}
