package com.kas08.kas0807.services;

import java.util.List;

import com.kas08.kas0807.domain.Usuario;

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario findById(Long id);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    Usuario updateUsuario(Usuario usuario);
}