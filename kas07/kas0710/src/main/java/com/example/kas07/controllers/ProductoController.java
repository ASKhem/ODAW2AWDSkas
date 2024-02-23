package com.example.kas07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kas07.domain.Categoria;
import com.example.kas07.domain.Producto;
import com.example.kas07.services.CategoriaService;
import com.example.kas07.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("productos", productoService.getProductos());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("categoriaSeleccionada", new Categoria(0L, "Todas"));
        return "producto/productos";
    }

    @GetMapping("/porCateg/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("productos", productoService.findByCategory(idCat));
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("categoriaSeleccionada", categoriaService.findById(idCat));
        return "producto/productos";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "producto/productoForm";
    }

    @PostMapping("/new/submit")
    public String createProducto(@ModelAttribute("producto") Producto producto, @RequestParam("categoria") Long categoriaId) {
        Categoria categoriaSeleccionada = categoriaService.findById(categoriaId);
        producto.setCategoria(categoriaSeleccionada);

        productoService.save(producto);
        return "redirect:/productos";
    }
    @GetMapping("/edit")
    public String editProducto(@RequestParam("id") Long id, Model model) {
        model.addAttribute("producto", productoService.findById(id));
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "producto/editarProductoView";
    }

    @PostMapping("/edit/submit")
    public String updateProducto(@ModelAttribute("producto") Producto producto, @RequestParam("categoria") Long categoriaId) {
        Categoria categoriaSeleccionada = categoriaService.findById(categoriaId);
        producto.setCategoria(categoriaSeleccionada);
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete")
    public String deleteProducto(@RequestParam("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }
}
