package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.Genero;
import com.example.kas07.repositories.EmpleadoRepository;

@Service
public class EmpleadoService implements HelperService<Empleado>{
    @Autowired
    EmpleadoRepository repositorio;

    public Empleado añadir(Empleado empleado) {
        String imagen = (empleado.getGenero() == Genero.HOMBRE)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
        empleado.setImagen(imagen);
        return repositorio.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return repositorio.findAll();
    }

    public Empleado obtenerPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        String imagen = (empleado.getGenero() == Genero.HOMBRE)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
        empleado.setImagen(imagen);
        return repositorio.save(empleado);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor(double salario) {
        return repositorio.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorio.obtenerEmpleadoSalarioMayorMedia();
    }

    public List<Empleado> obtenerEmpleadosDepartamento(Long id) {
        return repositorio.findByDepartamentoId(id);
    }

    public List<Empleado> obtenerEmpleadosCategoria(Long id) {
        return repositorio.findByCategoriaId(id);
    }
    
}
