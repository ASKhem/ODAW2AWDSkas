package com.kas08.kas0804.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.kas08.kas0804.domain.Empleado;
import com.kas08.kas0804.domain.Genero;
import com.kas08.kas0804.exceptions.EmpleadoNotFoundException;
import com.kas08.kas0804.exceptions.EmptyEmpleadosException;
import com.kas08.kas0804.repositories.EmpleadoRepository;

@Service
@Primary
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        String imagen = (empleado.getGenero() == Genero.HOMBRE)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
        empleado.setImagen(imagen);
        return repositorio.save(empleado);
    }

    public Empleado obtenerPorId(Long id) {
            return repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    public Empleado editar(Empleado empleado) {
        if(empleado.getId()!=null) {
            return repositorio.save(empleado);
        }
        return null;
    }

    public void borrar(Long id) {
        if (id != null) {
            Empleado empleado = repositorio.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
            repositorio.delete(empleado);
        }
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }

    public List<Empleado> obtenerTodos() {
        List <Empleado> empleados = repositorio.findAll();
        if(empleados.isEmpty()) {
            throw new EmptyEmpleadosException();
        }
        return empleados;
    }
}
