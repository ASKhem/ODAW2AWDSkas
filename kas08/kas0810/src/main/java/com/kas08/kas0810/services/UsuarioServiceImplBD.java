package com.kas08.kas0810.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.exceptions.GenericNotFoundException;
import com.kas08.kas0810.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplBD implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public List<Usuario> getUsuarios() {
        if(repository.findAll().isEmpty()) throw new GenericNotFoundException();
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException());
    }

    public Usuario createUsuario(Usuario usuario) {
        usuario.setFechaRegistro(LocalDate.now());
        return repository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return repository.save(usuario);
    }
}
