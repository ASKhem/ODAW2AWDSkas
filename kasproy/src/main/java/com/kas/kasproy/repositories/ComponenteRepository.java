package com.kas.kasproy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas.kasproy.model.product.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    public List<Componente> findByCategoria(String categoria);
}