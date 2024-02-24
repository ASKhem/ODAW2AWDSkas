package com.kas09.store.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.store.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByCategoriaId(Long id);
}