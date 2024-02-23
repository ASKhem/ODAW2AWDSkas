package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoDTO;
import com.example.kas07.exceptions.NotFoundException;

public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);
    public List<Empleado> obtenerTodos();
    public Empleado obtenerPorId(Long id) throws NotFoundException;
    public Empleado editar(Empleado empleado);
    public void borrar(Long id) throws NotFoundException;
    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados);
    
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}
