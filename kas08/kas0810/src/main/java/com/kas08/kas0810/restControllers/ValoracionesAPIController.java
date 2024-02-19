package com.kas08.kas0810.restControllers;

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

import com.kas08.kas0810.domain.Producto;
import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.domain.Valoracion;
import com.kas08.kas0810.services.ProductoService;
import com.kas08.kas0810.services.UsuarioService;
import com.kas08.kas0810.services.ValoracionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Valoraciones", description = "API para manejar las valoraciones de productos")
@RestController
@RequestMapping("/api/valoraciones")
public class ValoracionesAPIController {
    @Autowired
    public ValoracionService valoracionService;
    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProductoService productoService;

    @Operation(summary = "Lista todas las valoraciones",
        description = "Devuelve una lista con todas las valoraciones",
        tags = {"Valoraciones"}
    )
    @GetMapping("/list/usuario/{id}") //lista de valoraciones de un usuario
    public ResponseEntity<?> listaValoracionesUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        List<Valoracion> valoraciones = valoracionService.findByUsuario(usuario);
        return ResponseEntity.ok(valoraciones);
    }

    @Operation(summary = "Lista todas las valoraciones",
        description = "Devuelve una lista con todas las valoraciones",
        tags = {"Valoraciones"}
    )
    @GetMapping("/producto/{id}") //lista de valoraciones de un producto
    public ResponseEntity<?> listaValoracionesProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        List<Valoracion> valoraciones = valoracionService.findByProducto(producto);
        return ResponseEntity.ok(valoraciones);
    }

    @Operation(summary = "Crea una nueva valoracion",
        description = "Crea una nueva valoracion y la devuelve",
        tags = {"Valoraciones"})
    @PostMapping("/new/{id}") //crear una valoracion
    public ResponseEntity<?> crearValoracion(@RequestBody Valoracion valoracion, @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        valoracion.setUsuario(usuario);
        Producto producto = productoService.findById(valoracion.getProducto().getId());
        valoracion.setProducto(producto);
        Valoracion createdValoracion = valoracionService.createValoracion(valoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdValoracion);
    }

    @Operation(summary = "Borra una valoracion",
        description = "Borra una valoracion",
        tags = {"Valoraciones"})
    @DeleteMapping("/delete/{id}") //borrar una valoracion
    public ResponseEntity<?> borrarValoracion(@PathVariable Long id) {
        Valoracion valoracion = valoracionService.findById(id);
        valoracionService.deleteValoracion(valoracion);
        return ResponseEntity.noContent().build();
    }
}

