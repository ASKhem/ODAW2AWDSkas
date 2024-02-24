package com.kas09.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas09.store.domain.Categoria;
import com.kas09.store.domain.ConsultaForm;
import com.kas09.store.services.CategoriaService;
import com.kas09.store.services.ProductoService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/public")
public class PublicController {
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    ProductoService productoService;

    @GetMapping({"home", "/", "/index"})
    public String getHomePage() {
        return "public/index";
    }
    
    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "public/quienes-somos";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("consultaForm", new ConsultaForm());
        return "public/contacta";
    }

    @PostMapping("/contacta/submit")
    public String submitConsulta(@ModelAttribute @Valid ConsultaForm consultaForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "public/contacta";
        }
        model.addAttribute("enviar", "Tu consulta ha sido enviada con éxito.");
        return "public/contacta";
    }

    @GetMapping("/categorias/list")
    public String lista(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "categoria/category";
    }

    @GetMapping("/productos/list")
    public String showList(Model model) {
        model.addAttribute("productos", productoService.getProductos());
        model.addAttribute("categorias", categoriaService.getCategorias());
        model.addAttribute("categoriaSeleccionada", new Categoria(0L, "Todas"));
        return "producto/productos";
    }
}
