package com.kas08.kas0803.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0803.domain.Departamento;
import com.kas08.kas0803.domain.Empleado;
import com.kas08.kas0803.dto.EmpleadoShowDTO;
import com.kas08.kas0803.dto.EmpleadosAddOrEditDTO;
import com.kas08.kas0803.services.DepartamentoService;
import com.kas08.kas0803.services.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({ "/", "/list", "empleados" })
    /*
        ResponseEntity<?> es una clase que nos permite devolver un objeto o un error, 
        en este caso, un objeto de tipo List<Empleado> o un error. 
    */
    public ResponseEntity<?> getList() {
        List<Empleado> empleados = empleadoService.obtenerTodos();
        List<EmpleadoShowDTO> empleadosDTO = empleadoService.convertEmpleadoToDto(empleados);
        return ResponseEntity.ok(empleadosDTO);
        /*
         *  ResponseEntity.ok(empleados) devuelve un objeto de tipo ResponseEntity 
         * con el código de estado 200 (OK) y el objeto empleados como cuerpo de la respuesta.
        */
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getEmpleado(@PathVariable long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> newEmpleado(@Valid @RequestBody EmpleadosAddOrEditDTO newEmpleado){
        
        //requestBody es una anotación que indica que el parámetro se va a obtener del cuerpo de la petición.
        Empleado empleado = empleadoService.añadir(empleadoService.addOrEditEmpleadoDTO(newEmpleado));
        Departamento departamento = departamentoService.obtenerPorId(newEmpleado.getDepartamentoId());
        empleado.setDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.obtenerPorId(empleado.getId()));
        //CREATED código de estado 201 (CREATED)
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody EmpleadosAddOrEditDTO editEmpleado){
        Empleado empleado = empleadoService.obtenerPorId(editEmpleado.getId());
        if(empleado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        empleado = empleadoService.editar(empleadoService.addOrEditEmpleadoDTO(editEmpleado));
        Departamento departamento = departamentoService.obtenerPorId(editEmpleado.getDepartamentoId());
        empleado.setDepartamento(departamento);
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.obtenerPorId(empleado.getId()));
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> showDelete(@PathVariable Long id){
        Empleado empleado = empleadoService.obtenerPorId(id);
        if(empleado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        empleadoService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listado1/{salario}")
    public ResponseEntity<?> getEmpleadosSalarioMayor(@PathVariable double salario){
        List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor(salario);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/listado2")
    public ResponseEntity<?> getEmpleadosSalarioMayorMedia(){
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        return ResponseEntity.ok(empleados);
    }
}

