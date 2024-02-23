package com.example.clinica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.clinica.config.Tarifas;
import com.example.clinica.domain.Paciente;
import com.example.clinica.domain.PacienteConsulta;
import com.example.clinica.domain.PacienteDTO;
import com.example.clinica.domain.PacienteRecetas;
import com.example.clinica.domain.PacienteRevision;
import com.example.clinica.repositories.PacienteRepository;

@Controller
public class PacienteServiceImplMem implements PacienteService{
    @Autowired
    public PacienteRepository pacienteRepository;
    
    @Autowired
    public Tarifas tarifas;

    public void add(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public void deleteFirst() {
        pacienteRepository.delete(pacienteRepository.getFirst());
    }

    public Paciente getFirst() {
        return pacienteRepository.getFirst();
    }

    public List<Paciente> findAll() {
        List<Paciente> pacientes = new ArrayList<>();
        pacienteRepository.findAll().forEach(pacientes::add);
        return pacientes;
    }

    public Double facturar(Paciente paciente) {
        if(paciente != null){
            return paciente.facturar(tarifas);
        }else return 0d;
    }

    public Paciente buildPacientefromDTO(PacienteDTO pacienteDTO){
        Paciente paciente;
        switch (pacienteDTO.getTipoPaciente()) {
            case 1 ->{
                paciente = new PacienteConsulta();
                ((PacienteConsulta)paciente).setMotivoConsulta(pacienteDTO.getMotivoConsulta());
            }
            case 2 ->{
                paciente = new PacienteRecetas();
                ((PacienteRecetas)paciente).setListaMedicamentos(pacienteDTO.getListaMedicamentos());
            }
            case 3 ->{
                paciente = new PacienteRevision();
                ((PacienteRevision)paciente).setFechaUltimaRevision(pacienteDTO.getFechaUltimaRevision());
            }
                
            default -> {return null;}
        }
        paciente.setDni(pacienteDTO.getDni());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setNombre(pacienteDTO.getNombre());

        return paciente;
    }
}

