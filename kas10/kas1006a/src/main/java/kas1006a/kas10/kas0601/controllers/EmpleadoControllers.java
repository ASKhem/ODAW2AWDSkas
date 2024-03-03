package kas1006a.kas10.kas0601.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kas1006a.kas10.kas0601.domain.Empleado;
import kas1006a.kas10.kas0601.exceptions.NotFoundException;
import kas1006a.kas10.kas0601.services.EmpleadoService;

@Controller
public class EmpleadoControllers {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(@RequestParam (required = false)Integer op,Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        if (op!=null){
            switch (op) {
                case 1: model.addAttribute("msg","Empleado añadido correctamente");break;
                case 2: model.addAttribute("msg","Empleado editado correctamente");break;
                case 3: model.addAttribute("msg","Empleado borrado correctamente");break;
                case 4: model.addAttribute("msg","Empleado no se ha podido editar correctamente");break;
                case 5: model.addAttribute("msg","Empleado no se ha podido borrado correctamente");break;
                case 6: model.addAttribute("msg","Datos incorrectos");break;
            }
        }
        return "listView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        return "newFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) 
        return "redirect:/?op=6";
    empleadoService.añadir(empleadoForm);    
        return "redirect:/?op=1";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Empleado empleado;
        try {
            empleado = empleadoService.obtenerPorId(id);
        } catch (NotFoundException e) {
            return "redirect:/?op=4";
        }
        model.addAttribute("empleadoForm", empleado);
        return "editFormView";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(@Valid Empleado empleadoForm,BindingResult bindingResult) {
        if (!bindingResult.hasErrors()){
            return "redirect:/?op=6";
        }
        empleadoService.editar(empleadoForm);
        return "redirect:/?op=2";
    }

    @GetMapping("/borrar/{id}")
    public String showDelete(@PathVariable long id, Model model) {
        try {
            empleadoService.borrar(id);
        } catch (NotFoundException e) {
            return "redirect:/?op=5";
        }
        return "redirect:/?op=3";
    }
}
