package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoProyecto;
import com.example.kas07.domain.Proyecto;

public interface EmpleadoProyectoService{
    public EmpleadoProyecto añadir (EmpleadoProyecto empleadoProyecto);
    public EmpleadoProyecto obtenerPorId (Long id);
    public void borrar (EmpleadoProyecto empleadoProyecto);
    public List<EmpleadoProyecto> obtenerPorEmpleado(Empleado empleado);
    public List<EmpleadoProyecto> obtenerPorProyecto(Proyecto proyecto);
    public EmpleadoProyecto obtenerPorEmpleadoProyecto(Empleado e, Proyecto p);
}
