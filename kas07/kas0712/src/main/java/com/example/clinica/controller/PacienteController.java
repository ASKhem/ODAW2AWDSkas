package com.example.clinica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.clinica.domain.Paciente;
import com.example.clinica.domain.PacienteDTO;
import com.example.clinica.service.PacienteService;

import jakarta.validation.Valid;

@Controller
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping({"", "/", "/home"})
    public String showList(Model model){
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", 0d);
        return "pacientesList";
    }

    @GetMapping("/newPaciente")
    public String showNew (Model model){
        model.addAttribute("newPaciente", new PacienteDTO());
        return "pacienteNewView";
    }

    @PostMapping("/newPaciente/submit")
    public String submitNew (@Valid @ModelAttribute PacienteDTO newPacienteDTO, BindingResult result){
        

        if(!result.hasErrors()){
            Paciente newPaciente = pacienteService.buildPacientefromDTO(newPacienteDTO);
            pacienteService.add(newPaciente);
        }
        
        return "redirect:/";
    }

    @GetMapping("/deletePaciente")
    public String showDelete(Model model){
        Paciente paciente = pacienteService.getFirst();
        double factura = 0d;
        if(paciente != null){
            factura = pacienteService.facturar(paciente);
            pacienteService.deleteFirst();
        }
        model.addAttribute("listaPacientes", pacienteService.findAll());
        model.addAttribute("factura", factura);
        return "pacientesList";
    }
}
