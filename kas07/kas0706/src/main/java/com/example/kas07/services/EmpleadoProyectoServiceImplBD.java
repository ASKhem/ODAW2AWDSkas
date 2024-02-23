package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoProyecto;
import com.example.kas07.domain.Proyecto;
import com.example.kas07.repositories.EmpleadoProyectoRepository;

@Service
public class EmpleadoProyectoServiceImplBD implements EmpleadoProyectoService {
    @Autowired
    EmpleadoProyectoRepository empleadoProyectoRepository;

    public EmpleadoProyecto obtenerPorId(Long id) {
        return empleadoProyectoRepository.findById(id).orElse(null);
    }

    public EmpleadoProyecto añadir(EmpleadoProyecto empleadoProyecto) {
        return empleadoProyectoRepository.save(empleadoProyecto);
    }

    public void borrar(EmpleadoProyecto empleadoProyecto) {
        empleadoProyectoRepository.delete(empleadoProyecto);
    }

    public List<EmpleadoProyecto> obtenerPorEmpleado(Empleado empleado) {
        return empleadoProyectoRepository.findByEmpleado(empleado);
    }

    public List<EmpleadoProyecto> obtenerPorProyecto(Proyecto proyecto) {
        return empleadoProyectoRepository.findByProyecto(proyecto);
    }

    public EmpleadoProyecto obtenerPorEmpleadoProyecto(Empleado e, Proyecto p) {
        return empleadoProyectoRepository.findByEmpleadoAndProyecto(e, p);
    }
}