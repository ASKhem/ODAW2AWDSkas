package com.kas09.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kas09.store.domain.Producto;
import com.kas09.store.domain.Usuario;
import com.kas09.store.domain.Valoracion;
import com.kas09.store.services.ProductoService;
import com.kas09.store.services.UsuarioService;
import com.kas09.store.services.ValoracionService;

@Controller
@RequestMapping("/valoraciones")
public class ValoracionController {
    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

    @GetMapping("/usuario/{id}") //lista de valoraciones de un usuario
    public String listaValoracionesUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        model.addAttribute("valoraciones", valoracionService.findByUsuario(usuario));
        model.addAttribute("usuario", usuario);
        return "valoracion/valoracionList";
    }

    @GetMapping("/producto/{id}") //lista de valoraciones de un producto
    public String listaValoracionesProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id);
        model.addAttribute("valoraciones", valoracionService.findByProducto(producto));
        model.addAttribute("producto", producto);
        return "valoracion/valoracionList";
    }

    @GetMapping("/new") //crear una valoracion
    public String nuevaValoracion(Model model) {
        Usuario usuario = usuarioService.findUserByNombre(usuarioService.getCurrentUserName());
        model.addAttribute("usuario", usuario);
        model.addAttribute("productos", productoService.getProductos());
        model.addAttribute("valoracion", new Valoracion());
        return "valoracion/valoracionForm";
    }
    @PostMapping("/new/submit/{usuario}")
    public String crearValoracion(@ModelAttribute("valoracion") Valoracion valoracion, @PathVariable Long usuario, @RequestParam Long producto) {
        Usuario usuarioSeleccionado = usuarioService.findById(usuario);
        valoracion.setUsuario(usuarioSeleccionado);
        Producto productoSeleccionado = productoService.findById(producto);
        valoracion.setProducto(productoSeleccionado);
        valoracionService.createValoracion(valoracion);
        return "redirect:/valoraciones/usuario/" + usuario;
    }

    @GetMapping("/delete/{id}") //borrar una valoracion
    public String borrarValoracion(@PathVariable Long id) {
        Usuario usuario = valoracionService.findById(id).getUsuario();
        valoracionService.deleteValoracion(valoracionService.findById(id));
        return "redirect:/valoraciones/usuario/"+usuario.getId();
    }

}
