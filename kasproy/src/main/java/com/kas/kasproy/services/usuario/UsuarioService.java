package com.kas.kasproy.services.usuario;

import java.util.List;

import com.kas.kasproy.dto.UsuarioEditDto;
import com.kas.kasproy.dto.UsuarioNewDto;
import com.kas.kasproy.dto.UsuarioNewStandardDto;
import com.kas.kasproy.model.user.Usuario;

public interface UsuarioService {
    public Usuario createEstandardUsuario(UsuarioNewStandardDto usuarioDto);
    public Usuario createUsuario(UsuarioNewDto usuarioDto);
    public List<Usuario> getUsuarios();
    public Usuario findById(Long id);
    public void deleteUsuario(Long id);
    public Usuario updateUsuario(UsuarioEditDto usuarioDto);
    public String getCurrentUserName();
    public String getCurrentUserRole();
    public boolean isAdmin();
}
