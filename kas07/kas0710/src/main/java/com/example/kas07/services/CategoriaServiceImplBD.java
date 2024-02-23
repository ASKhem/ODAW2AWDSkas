package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Categoria;
import com.example.kas07.repositories.CategoryRepository;

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
