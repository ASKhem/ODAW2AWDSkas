package com.kas09.kas0901.services;

import java.util.List;

import com.kas09.kas0901.domain.Empleado;
import com.kas09.kas0901.exceptions.NotFoundException;

public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);
    public List<Empleado> obtenerTodos();
    public Empleado obtenerPorId(Long id) throws NotFoundException;
    public Empleado editar(Empleado empleado);
    public void borrar(Long id) throws NotFoundException;
    
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}
