package com.kas08.kas0810.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

@Tag(name = "Usuarios", description = "API para manejar los usuarios")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioAPIController {
    @Autowired
    UsuarioService usuarioService;

    @Operation(summary = "Lista todos los usuarios",
        description = "Devuelve una lista con todos los usuarios",
        tags = {"Usuarios"}
    )
    @GetMapping("/list")
    public ResponseEntity<?> lista() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @Operation(summary = "Crea un nuevo usuario",
        description = "Crea un nuevo usuario y lo devuelve",
        tags = {"Usuarios"})
    @PostMapping("/new")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @Operation(summary = "Edita un usuario",
        description = "Edita un usuario y lo devuelve",
        tags = {"Usuarios"})
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Edita un usuario",
        description = "Edita un usuario y lo devuelve",
        tags = {"Usuarios"})
    @PutMapping("/edit")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @Operation(summary = "Borra un usuario",
        description = "Borra un usuario",
        tags = {"Usuarios"})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}