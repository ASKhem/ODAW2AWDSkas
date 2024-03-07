package com.kas.kasproy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas.kasproy.model.product.Ordenador;

@Repository
public interface OrdenadorRepository extends JpaRepository<Ordenador, Long> {
    
}
