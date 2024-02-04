package com.kas08.kas0801.services;

import java.util.List;

import com.kas08.kas0801.domain.Empleado;

public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);
    public List<Empleado> obtenerTodos();
    public Empleado obtenerPorId(Long id);
    public Empleado editar(Empleado empleado);
    public void borrar(Long id);
    
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}
