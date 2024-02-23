package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Producto;
import com.example.kas07.repositories.ProductoRepository;

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
