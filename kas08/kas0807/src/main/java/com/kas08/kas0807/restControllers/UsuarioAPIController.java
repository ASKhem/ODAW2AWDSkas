package com.kas08.kas0807.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0807.domain.Usuario;
import com.kas08.kas0807.services.UsuarioService;

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


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioAPIController {
        @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<?> lista() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @PostMapping("/new")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}