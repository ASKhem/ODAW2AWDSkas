package com.kas08.kas0807.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0807.domain.Producto;
import com.kas08.kas0807.domain.Usuario;
import com.kas08.kas0807.domain.Valoracion;
import com.kas08.kas0807.services.ProductoService;
import com.kas08.kas0807.services.UsuarioService;
import com.kas08.kas0807.services.ValoracionService;

@RestController
@RequestMapping("/api/valoraciones")
public class ValoracionesAPIController {
    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

    @GetMapping("/list/usuario/{id}") //lista de valoraciones de un usuario
    public ResponseEntity<?> listaValoracionesUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        List<Valoracion> valoraciones = valoracionService.findByUsuario(usuario);
        return ResponseEntity.ok(valoraciones);
    }

    @GetMapping("/producto/{id}") //lista de valoraciones de un producto
    public ResponseEntity<?> listaValoracionesProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        List<Valoracion> valoraciones = valoracionService.findByProducto(producto);
        return ResponseEntity.ok(valoraciones);
    }

    @PostMapping("/new/{id}") //crear una valoracion
    public ResponseEntity<?> crearValoracion(@RequestBody Valoracion valoracion, @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        valoracion.setUsuario(usuario);
        Producto producto = productoService.findById(valoracion.getProducto().getId());
        valoracion.setProducto(producto);
        Valoracion createdValoracion = valoracionService.createValoracion(valoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdValoracion);
    }

    @DeleteMapping("/delete/{id}") //borrar una valoracion
    public ResponseEntity<?> borrarValoracion(@PathVariable Long id) {
        Valoracion valoracion = valoracionService.findById(id);
        valoracionService.deleteValoracion(valoracion);
        return ResponseEntity.noContent().build();
    }
}

