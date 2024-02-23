package com.example.kas07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kas07.domain.Categoria;
import com.example.kas07.services.HelperService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {
    public  final HelperService<Categoria> categoriaService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "categoria/listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("categoriaForm", new Categoria());
        return "categoria/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Categoria categoriaForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/categorias/new";
        categoriaService.añadir(categoriaForm);
        return "redirect:/categorias/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id)  throws Exception{
        categoriaService.borrar(id);
        return "redirect:/categorias/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        model.addAttribute("categoriaForm", categoria);
        return "categoria/editFormView";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid Categoria categoriaForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/categorias/edit/" + categoriaForm.getId();
        }
        categoriaService.editar(categoriaForm);
        return "redirect:/categorias/list";
    }
}
