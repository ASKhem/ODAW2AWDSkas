package com.kas08.kas0807.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas08.kas0807.domain.Producto;
import com.kas08.kas0807.exceptions.GenericNotFoundException;
import com.kas08.kas0807.repositories.ProductoRepository;

@Service
public class ProductServiceImplBD implements ProductoService{

    @Autowired
    public ProductoRepository repository;

    public List<Producto> getProductos() {
        if(repository.findAll().isEmpty()) throw new GenericNotFoundException();
        return repository.findAll();  
    }

    public Producto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException());
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
        if(repository.findByCategoriaId(id).isEmpty()) throw new GenericNotFoundException();
        return repository.findByCategoriaId(id);
    }
}
