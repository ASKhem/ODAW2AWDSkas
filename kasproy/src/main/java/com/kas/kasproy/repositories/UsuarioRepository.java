package com.kas.kasproy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas.kasproy.model.user.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
