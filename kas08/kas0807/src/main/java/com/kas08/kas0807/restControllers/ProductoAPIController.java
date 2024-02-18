package com.kas08.kas0807.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0807.domain.Categoria;
import com.kas08.kas0807.domain.Producto;
import com.kas08.kas0807.services.CategoriaService;
import com.kas08.kas0807.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoAPIController {
    @Autowired
    ProductoService productoService;
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("list")
    public ResponseEntity<?> showList() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/porCateg/{idCat}")
    public ResponseEntity<?>  showListInCategory(@PathVariable Long idCat) {
        return ResponseEntity.ok(productoService.findByCategory(idCat));
    }

    @PostMapping("/new")
    public ResponseEntity<?> createProducto(@RequestBody Producto producto, @RequestParam("categoria") Long categoriaId) {
        Categoria categoriaSeleccionada = categoriaService.findById(categoriaId);
        producto.setCategoria(categoriaSeleccionada);
        productoService.save(producto);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editProducto(@RequestBody Producto producto) {
        productoService.update(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProducto(@RequestParam("id") Long id) {
        productoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
