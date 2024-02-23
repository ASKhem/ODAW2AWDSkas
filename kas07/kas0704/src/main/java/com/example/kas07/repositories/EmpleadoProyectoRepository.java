package com.example.kas07.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoProyecto;
import com.example.kas07.domain.Proyecto;

public interface EmpleadoProyectoRepository extends JpaRepository<EmpleadoProyecto, Long> {
    // métodos derivado de nombre

    List<EmpleadoProyecto> findByEmpleado(Empleado empleado);

    List<EmpleadoProyecto> findByProyecto(Proyecto proyecto);

    EmpleadoProyecto findByEmpleadoAndProyecto(Empleado emp, Proyecto proy);
}