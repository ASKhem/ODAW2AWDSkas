package com.kas08.kas0803.services;

import java.util.List;

import com.kas08.kas0803.domain.Departamento;

public interface DepartamentoService {
    Departamento añadir(Departamento departamento);
    List<Departamento> obtenerTodos();
    Departamento obtenerPorId(long id);
    Departamento editar(Departamento departamento);
    void borrar(Departamento departamento);
    Departamento obtenerPorNombre(String nombre);
}
