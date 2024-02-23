package com.example.kas07.services;

import java.util.ArrayList;
import java.util.List;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoDTO;
import com.example.kas07.exceptions.NotFoundException;

public class EmpleadoServiceImplMem implements EmpleadoService{
        private List<Empleado> repositorio = new ArrayList<>();

    public Empleado añadir(Empleado empleado) {
        repositorio.add(empleado);
        return empleado; // podría no devolver nada, o boolean, etc.
    }

    public List<Empleado> obtenerTodos() {
        return repositorio;
    }

    public Empleado obtenerPorId(Long id) throws NotFoundException{
        for (Empleado empleado : repositorio)
            if (empleado.getId() == id)
                return empleado;
        //return null; // debería lanzar excepción si no encontrado
        throw new NotFoundException("Empleado no encontrado");
    }

    public Empleado editar(Empleado empleado) {
        int pos = repositorio.indexOf(empleado);
        if (pos == -1){
            return null; // debería lanzar excepción si no encontrado
        }
        repositorio.set(pos, empleado); // si lo encuentra, lo sustituye
        return empleado;
    }

    public void borrar(Long id) throws NotFoundException{
        Empleado empleado = this.obtenerPorId(id);
        if (empleado != null) {
            repositorio.remove(empleado); // podría devolver boolean
        }
    }

    @Override
    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEmpleadosSalarioMayor'");
    }

    @Override
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEmpleadoSalarioMayorMedia'");
    }

    @Override
    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertEmpleadoToDto'");
    }
}
