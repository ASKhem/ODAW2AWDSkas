package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Categoria;
import com.example.kas07.repositories.CategoriaRepository;


@Service
public class CategoriaService implements HelperService<Categoria>{
    @Autowired
    CategoriaRepository repositorio;

    @Autowired
    EmpleadoService empleadoService;

    public Categoria añadir(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public List<Categoria> obtenerTodos() {
        return repositorio.findAll();
    }

    public Categoria obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Categoria editar(Categoria categoria) {
        return repositorio.save(categoria);
    }

    public void borrar(Long id){
        repositorio.deleteById(id);
    }
}
