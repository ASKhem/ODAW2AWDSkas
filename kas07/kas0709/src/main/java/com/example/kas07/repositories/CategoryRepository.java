package com.example.kas07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Long>{
    
}
