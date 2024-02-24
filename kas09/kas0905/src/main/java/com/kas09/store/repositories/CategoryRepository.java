package com.kas09.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.store.domain.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Long>{
    
}
