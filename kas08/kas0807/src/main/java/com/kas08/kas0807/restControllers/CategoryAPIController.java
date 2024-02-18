package com.kas08.kas0807.restControllers;

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

import com.kas08.kas0807.domain.Categoria;
import com.kas08.kas0807.services.CategoriaService;
import com.kas08.kas0807.services.ProductoService;

@RestController
@RequestMapping("/api/categorias")
public class CategoryAPIController {

        @Autowired
        CategoriaService categoriaService;
        @Autowired
        ProductoService productoService;
    
        @GetMapping("list")
        public ResponseEntity<?> lista() {
            return ResponseEntity.ok(categoriaService.getCategorias());
        }
    
        @PostMapping("/new")
        public ResponseEntity<?> newCategory(@RequestBody Categoria categoria) {
            categoriaService.createCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }

        @PutMapping("/edit")
        public ResponseEntity<?> ditCategory(@RequestBody Categoria categoria) {
            categoriaService.updateCategoria(categoria);
            return ResponseEntity.ok(categoria);
        }
    
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteCategory(@PathVariable long id) {
                categoriaService.deleteCategoria(id);
                return ResponseEntity.noContent().build();
        }
    }
    
