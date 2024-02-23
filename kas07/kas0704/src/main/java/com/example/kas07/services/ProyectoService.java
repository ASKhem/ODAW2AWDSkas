package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Proyecto;
import com.example.kas07.repositories.ProyectoRepository;

@Service
public class ProyectoService implements HelperService<Proyecto>{

    @Autowired
    ProyectoRepository repository;
    
    public Proyecto añadir(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    public Proyecto obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Proyecto editar(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    public void borrar(Long id) {
        repository.deleteById(id);
    }

    public List<Proyecto> obtenerTodos() {
        return repository.findAll();
    }

    
}
