package com.kas08.kas0810.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0810.domain.Categoria;
import com.kas08.kas0810.services.CategoriaService;
import com.kas08.kas0810.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categorias", description = "API para manejar las categorias de productos")
@RestController
@RequestMapping("/api/categorias")
public class CategoryAPIController {

        @Autowired
        CategoriaService categoriaService;
        @Autowired
        ProductoService productoService;

        @Operation(summary = "Lista todas las categorias",
            description = "Devuelve una lista con todas las categorias",
            tags = {"Categorias"}
        )
        @GetMapping("list")
        public ResponseEntity<?> lista() {
            return ResponseEntity.ok(categoriaService.getCategorias());
        }
        
        @Operation(summary = "Crea una nueva categoria",
            description = "Crea una nueva categoria y la devuelve",
            tags = {"Categorias"})
        @PostMapping("/new")
        public ResponseEntity<?> newCategory(@RequestBody Categoria categoria) {
            categoriaService.createCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }

        @Operation(summary = "Edita una categoria",
            description = "Edita una categoria y la devuelve",
            tags = {"Categorias"})
        @PutMapping("/edit")
        public ResponseEntity<?> ditCategory(@RequestBody Categoria categoria) {
            categoriaService.updateCategoria(categoria);
            return ResponseEntity.ok(categoria);
        }
        
        @Operation(summary = "Borra una categoria",
            description = "Borra una categoria",
            tags = {"Categorias"})
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteCategory(@PathVariable long id) {
                categoriaService.deleteCategoria(id);
                return ResponseEntity.noContent().build();
        }
    }
    
