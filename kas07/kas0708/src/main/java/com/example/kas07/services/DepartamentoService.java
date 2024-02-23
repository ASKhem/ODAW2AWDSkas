package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Departamento;

public interface DepartamentoService {
    Departamento añadir(Departamento departamento);
    List<Departamento> obtenerTodos();
    Departamento obtenerPorId(long id);
    Departamento editar(Departamento departamento);
    void borrar(Departamento departamento);
    Departamento obtenerPorNombre(String nombre);
}
