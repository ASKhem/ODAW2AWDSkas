package com.example.kas07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
