package com.example.kas07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kas07.domain.Categoria;
import com.example.kas07.services.CategoriaService;
import com.example.kas07.services.ProductoService;

@Controller
@RequestMapping("/categorias")
public class CategoryController {
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ProductoService productoService;

    @GetMapping("")
    public String lista(@RequestParam (required = false) String error, Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        if(error != null){
            model.addAttribute("error", "Se ha borrado la categoria");
        }
        return "categoria/category";
    }

    @GetMapping("/new")
    public String newCategory(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/categoryForm";
    }

    @PostMapping("/new/submit")
    public String createCategory(Categoria categoria) {
        categoriaService.createCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/edit")
    public String editCategory(@RequestParam("id") Long id, Model model) {
        model.addAttribute("categoria", categoriaService.findById(id));
        return "categoria/categoryEditView";
    }

    @PostMapping("/edit/submit")
    public String updateCategory(Categoria categoria) {
        categoriaService.updateCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
            categoriaService.deleteCategoria(id);
            return "redirect:/categorias?error=1";
    }


}
