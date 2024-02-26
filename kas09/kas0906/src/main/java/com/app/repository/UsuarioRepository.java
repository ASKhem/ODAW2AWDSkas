package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findByNombre(String nombre);

  Boolean existsByNombre(String nombre);

  Boolean existsByEmail(String email);
}
