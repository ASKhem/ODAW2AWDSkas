package com.kas08.kas0803.services;

import java.util.List;

import com.kas08.kas0803.domain.Empleado;
import com.kas08.kas0803.dto.EmpleadoShowDTO;
import com.kas08.kas0803.dto.EmpleadosAddOrEditDTO;
public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);
    public List<Empleado> obtenerTodos();
    public Empleado obtenerPorId(Long id);
    public Empleado editar(Empleado empleado);
    public void borrar(Long id);
    
    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

    public List<EmpleadoShowDTO> convertEmpleadoToDto(List<Empleado> empleados);
    public Empleado addOrEditEmpleadoDTO(EmpleadosAddOrEditDTO empleadoDto);

}
