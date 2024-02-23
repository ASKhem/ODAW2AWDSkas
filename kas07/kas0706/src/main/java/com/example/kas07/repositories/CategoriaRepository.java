package com.example.kas07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
