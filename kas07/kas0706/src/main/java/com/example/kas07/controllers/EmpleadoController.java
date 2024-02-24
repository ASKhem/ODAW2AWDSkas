package com.example.kas07.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kas07.domain.Categoria;
import com.example.kas07.domain.Departamento;
import com.example.kas07.domain.Empleado;
import com.example.kas07.services.EmpleadoService;
import com.example.kas07.services.HelperService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public HelperService<Departamento> departamentoService;
    @Autowired
    public HelperService<Categoria> categoriaService;


    @GetMapping()
    public String showList(@RequestParam(required = false) Integer op, Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", 0);
        if (op != null) {
            switch (op) {
                case 1:model.addAttribute("msgDone", "Empleado añadido correctamente");break;
                case 2:model.addAttribute("msgDone", "Empleado editado correctamente");break;
                case 3:model.addAttribute("msgDone", "Empleado borrado correctamente");break;
                case 4:model.addAttribute("msgFailed", "Empleado no se ha podido editar correctamente");break;
                case 5:model.addAttribute("msgFailed", "Empleado no se ha podido borrado correctamente");break;
                case 6:model.addAttribute("msgFailed", "Datos incorrectos");break;
            }
        }
        return "/empleados/listView";
    }

    @GetMapping("/porDepto/{id}")
    public String showListPorDepto(@PathVariable Long id, Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerEmpleadosDepartamento(id));
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", id);
        return "/empleados/listView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
        model.addAttribute("empleadoForm", new Empleado());
        return "/empleados/newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/?op=6";
        empleadoService.añadir(empleadoForm);
        return "redirect:/empleados?op=1";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
        model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
        Empleado empleado = empleadoService.obtenerPorId(id);
        model.addAttribute("empleadoForm", empleado);
        return "/empleados/editFormView";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/empleados/?op=6";
        }
        empleadoService.editar(empleadoForm);
        return "redirect:/empleados?op=2";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        empleadoService.borrar(id);
        return "redirect:/empleados?op=3";
    }

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor(salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que" + salario.toString());
        model.addAttribute("listaEmpleados", empleados);
        return "/empleados/listadosView";
    }

    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media");
        model.addAttribute("listaEmpleados", empleados);
        return "/empleados/listadosView";
    }
}