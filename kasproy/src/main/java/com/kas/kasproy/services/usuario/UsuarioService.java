package com.kas.kasproy.services.usuario;

import java.util.List;

import com.kas.kasproy.model.user.Usuario;

public interface UsuarioService {
    public Usuario createUsuario(Usuario usuario);
    public List<Usuario> getUsuarios();
    public Usuario findById(Long id);
    public void deleteUsuario(Long id);
    public Usuario updateUsuario(Usuario usuario);
}
