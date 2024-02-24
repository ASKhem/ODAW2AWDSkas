package com.kas09.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.store.domain.Categoria;
import com.kas09.store.repositories.CategoryRepository;

@Service
public class CategoriaServiceImplBD implements CategoriaService{
    @Autowired
    CategoryRepository repository;


    public List<Categoria> getCategorias() {
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria createCategoria(Categoria categoria) {
        return repository.save(categoria);
    }
    
    public void deleteCategoria(Long id) {
        repository.deleteById(id);
    }

    public Categoria updateCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

}
