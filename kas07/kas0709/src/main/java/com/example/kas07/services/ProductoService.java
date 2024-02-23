package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Producto;

public interface ProductoService {
    List<Producto> getProductos();
    Producto findById(Long id);
    Producto save(Producto producto);
    void update(Producto producto);
    void deleteById(Long id);
    List<Producto> findByCategory(Long idCat);
}