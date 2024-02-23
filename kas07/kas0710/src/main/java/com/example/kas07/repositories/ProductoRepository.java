package com.example.kas07.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByCategoriaId(Long id);
}