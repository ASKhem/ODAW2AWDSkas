package com.kas08.kas0810.services;

import java.util.List;

import com.kas08.kas0810.domain.Producto;

public interface ProductoService {
    List<Producto> getProductos();
    Producto findById(Long id);
    Producto save(Producto producto);
    void update(Producto producto);
    void deleteById(Long id);
    List<Producto> findByCategory(Long idCat);
}