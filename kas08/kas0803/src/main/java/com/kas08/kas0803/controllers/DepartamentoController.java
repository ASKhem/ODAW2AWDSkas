package com.kas08.kas0803.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/new")
    public ResponseEntity<?> showNewForm() {
        return ResponseEntity.ok(new Departamento());
    }

    @PostMapping("/new/submit")
    public ResponseEntity<?> showNewSubmit(@Valid Departamento departamento, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            return ResponseEntity.ok(departamentoService.añadir(departamento));
        else
            return ResponseEntity.badRequest().body("Error en los datos");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        departamentoService.borrar(departamentoService.obtenerPorId(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> showEdit(@PathVariable long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null)
            return ResponseEntity.ok(departamento);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/edit/submit")
    public ResponseEntity<?> showEditSubmit(@Valid Departamento departamento, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            return ResponseEntity.ok(departamentoService.editar(departamento));
        else
            return ResponseEntity.badRequest().body("Error en los datos");
    }
}