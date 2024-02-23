package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Departamento;
import com.example.kas07.repositories.DepartamentoRepository;

@Service
public class DepartamentoService implements HelperService<Departamento>{
    @Autowired
    DepartamentoRepository repositorio;

    public Departamento añadir(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }

    public Departamento obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public Departamento obtenerPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}