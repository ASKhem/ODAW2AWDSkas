package com.kas08.kas0803.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.kas08.kas0803.domain.Empleado;
import com.kas08.kas0803.domain.Genero;
import com.kas08.kas0803.dto.EmpleadoShowDTO;
import com.kas08.kas0803.dto.EmpleadosAddOrEditDTO;
import com.kas08.kas0803.repositories.EmpleadoRepository;

@Service
@Primary
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorio;
    @Autowired
    public ModelMapper modelMapper;

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

    /*
     *Este método basicamente convierte una lista de empleados a una lista de EmpleadoShowDTO
     *mostrando solo los campos que nos interesan. 
     */
    public List<EmpleadoShowDTO> convertEmpleadoToDto(List<Empleado> empleados) {
        List <EmpleadoShowDTO> empleadosDto = new ArrayList<>();
        for (Empleado empleado : empleados) {
            EmpleadoShowDTO empleadoDto = modelMapper.map(empleado, EmpleadoShowDTO.class);
            empleadosDto.add(empleadoDto);
        }
        return empleadosDto;
    }

    public Empleado addOrEditEmpleadoDTO(EmpleadosAddOrEditDTO empleadoDto) {
        Empleado empleado = modelMapper.map(empleadoDto, Empleado.class);
        return empleado;
    }
}
