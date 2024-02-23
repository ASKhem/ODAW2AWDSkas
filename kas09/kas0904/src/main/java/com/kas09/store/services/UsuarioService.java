package com.kas09.store.services;

import java.util.List;

import com.kas09.store.domain.Usuario;

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario findById(Long id);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    Usuario updateUsuario(Usuario usuario);
}