package com.example.kas1006c.services;

import java.util.List;

import com.example.kas1006c.domain.Empleado;
import com.example.kas1006c.exceptions.NotFoundException;

public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);
    public List<Empleado> obtenerTodos();
    public Empleado obtenerPorId(Long id) throws NotFoundException;
    public Empleado editar(Empleado empleado);
    public void borrar(Long id) throws NotFoundException;
    
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}
