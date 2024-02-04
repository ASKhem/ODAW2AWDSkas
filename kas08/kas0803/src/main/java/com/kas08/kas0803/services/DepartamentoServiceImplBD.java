package com.kas08.kas0803.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.kas08.kas0803.domain.Departamento;
import com.kas08.kas0803.repositories.DepartamentoRepository;

@Primary
@Service
public class DepartamentoServiceImplBD implements DepartamentoService {
    @Autowired
    DepartamentoRepository repositorio;

    public Departamento añadir(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public List<Departamento> obtenerTodos() {
        return repositorio.findAll();
    }

    public Departamento obtenerPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Departamento editar(Departamento departamento) {
        return repositorio.save(departamento);
    }

    public void borrar(Departamento departamento) {
        repositorio.delete(departamento); // también es cómodo deleteById(id)
    }

    public Departamento obtenerPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}