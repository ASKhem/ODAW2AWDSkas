package com.kas08.kas0806.controllers;

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

import com.kas08.kas0806.domain.Empleado;
import com.kas08.kas0806.services.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping({ "/", "/list", "empleados" })
    public ResponseEntity<List<Empleado>> getList() {
        List<Empleado> empleados = empleadoService.obtenerTodos();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getEmpleado(@PathVariable long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/empleado/new")
    public ResponseEntity<?> newEmpleado(@Valid @RequestBody Empleado newEmpleado){
        Empleado empleado = empleadoService.añadir(newEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/empleado/edit/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id){
        if(empleadoService.obtenerPorId(id)==null) {
            return ResponseEntity.notFound().build();
        }
        if(id != editEmpleado.getId()) {
            //tipo de error 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        empleadoService.editar(editEmpleado);
        return ResponseEntity.status(HttpStatus.OK).body(editEmpleado);
    }

    @DeleteMapping("/empleado/delete/{id}")
    public ResponseEntity<?> showDelete(@PathVariable Long id){
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

