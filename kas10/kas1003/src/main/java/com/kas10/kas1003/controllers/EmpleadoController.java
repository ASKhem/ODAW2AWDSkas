package com.kas10.kas1003.controllers;

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

import com.kas10.kas1003.domain.Empleado;
import com.kas10.kas1003.services.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping({ "/", "/list", "empleados" })
    /*
        ResponseEntity<?> es una clase que nos permite devolver un objeto o un error,
        en este caso, un objeto de tipo List<Empleado> o un error. 
    */
    public ResponseEntity<?> getList() {
        List<Empleado> empleados = empleadoService.obtenerTodos();
        return ResponseEntity.ok(empleados);
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

    @PostMapping("/empleado/new")
    public ResponseEntity<?> newEmpleado(@Valid @RequestBody Empleado newEmpleado){
        Empleado empleado = empleadoService.añadir(newEmpleado);
        if (empleado == null) {
            return new ResponseEntity<>("El salario debe estar comprendido entre 1000 y 5000 euros.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/empleado/edit/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody Empleado editEmpleado, @PathVariable Long id){
        //comprobamos que existe el empleado
        if(empleadoService.obtenerPorId(id)==null) {
            //tipo de error 404
            return ResponseEntity.notFound().build();
        }
        //controlar que sea el empleado
        if(id != editEmpleado.getId()) {
            //tipo de error 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        empleadoService.editar(editEmpleado);
        return ResponseEntity.status(HttpStatus.OK).body(editEmpleado);
    }

    @DeleteMapping("/empleado/delete/{id}")
    public ResponseEntity<?> showDelete(@PathVariable Long id){
        Empleado empleado = empleadoService.obtenerPorId(id);
        if(empleado==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//devuelve 404
        }

        empleadoService.borrar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//devuelve 204
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

