package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Usuario;

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario findById(Long id);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    Usuario updateUsuario(Usuario usuario);
}