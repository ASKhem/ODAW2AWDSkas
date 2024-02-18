package com.kas08.kas0803.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0803.domain.Departamento;
import com.kas08.kas0803.services.DepartamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/depto")
public class DepartamentoController {
    @Autowired
    public DepartamentoService departamentoService;

    @GetMapping({ "/", "/list" })
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(departamentoService.obtenerTodos());
    }

    @PostMapping("/new")
    public ResponseEntity<?> showNewSubmit(@Valid @RequestBody Departamento departamento, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()){
            return ResponseEntity.ok(departamentoService.añadir(departamento));
        }else{
            System.out.println(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body("Error en los datos");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        departamentoService.borrar(departamentoService.obtenerPorId(id));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> showEdit(@Valid @RequestBody Departamento departamento, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()){
            return ResponseEntity.ok(departamentoService.editar(departamento));
        }else{
            System.out.println(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body("Error en los datos");
        }
    }
}