package com.kas09.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.store.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUserByNombre(String nombre);
}
