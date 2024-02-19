package com.kas08.kas0810.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas08.kas0810.domain.Categoria;
import com.kas08.kas0810.exceptions.GenericNotFoundException;
import com.kas08.kas0810.repositories.CategoryRepository;

@Service
public class CategoriaServiceImplBD implements CategoriaService{
    @Autowired
    CategoryRepository repository;


    public List<Categoria> getCategorias() {
        if(repository.findAll().isEmpty()) throw new GenericNotFoundException();
        return repository.findAll();
    }

    public Categoria findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException());
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
