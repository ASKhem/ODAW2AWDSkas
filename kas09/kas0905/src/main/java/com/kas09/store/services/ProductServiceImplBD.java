package com.kas09.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.store.domain.Producto;
import com.kas09.store.repositories.ProductoRepository;

@Service
public class ProductServiceImplBD implements ProductoService{

    @Autowired
    public ProductoRepository repository;

    public List<Producto> getProductos() {
        return repository.findAll();
    }

    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public void update(Producto producto) {
        repository.save(producto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> findByCategory(Long id) {
        return repository.findByCategoriaId(id);
    }
}
