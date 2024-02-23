package com.kas09.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.bank.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{
    Usuario findUserById(Long id);
    Usuario findUserByNombre(String nombre);
}
