package com.example.kas07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.EmpleadoProyecto;
import com.example.kas07.domain.Proyecto;
import com.example.kas07.services.EmpleadoProyectoService;
import com.example.kas07.services.EmpleadoService;
import com.example.kas07.services.ProyectoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/emplProy")
public class EmpleadoProyectoController {
    @Autowired
    public EmpleadoProyectoService empleadoProyectoService;
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public ProyectoService proyectoService;

    @GetMapping("/emp/{id}") // lista de proyectos de un empleado
    public String showProyectsByEmpl(@PathVariable long id, Model model) {
        Empleado e = empleadoService.obtenerPorId(id);
        model.addAttribute("listaEmpleadoProyecto",
                empleadoProyectoService.obtenerPorEmpleado(e));
        model.addAttribute("empleado", empleadoService.obtenerPorId(id));
        return "empleadoProyecto/empListView";
    }

    @GetMapping("/pro/{id}") // lista de empleados de un proyecto
    public String showEmplbyProyect(@PathVariable long id, Model model) {
        Proyecto p = proyectoService.obtenerPorId(id);
        model.addAttribute("listaEmpleadoProyecto",
                empleadoProyectoService.obtenerPorProyecto(p));
        model.addAttribute("proyecto", proyectoService.obtenerPorId(id));
        return "empleadoProyecto/proListView";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteEmpl(@PathVariable long id) {
        empleadoProyectoService.borrar(empleadoProyectoService.obtenerPorId(id));
        return "redirect:/empleados";
    }

    @GetMapping("/new")
    public String showNewProjectEmpl(Model model) {
        model.addAttribute("empleadoProyectoForm", new EmpleadoProyecto());
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaProyectos", proyectoService.obtenerTodos());
        return "empleadoProyecto/empProyNewFormView";
    }

    @PostMapping("/new/submit")
    public String showNewProjectEmplSubmit(@Valid EmpleadoProyecto empleadoProyectoForm,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            empleadoProyectoService.añadir(empleadoProyectoForm);
        return "redirect:/empleados";
    }

}