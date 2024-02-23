package com.example.clinica.service;

import java.util.List;

import com.example.clinica.domain.Paciente;
import com.example.clinica.domain.PacienteDTO;

public interface PacienteService {
    void add(Paciente paciente);
    void deleteFirst();
    Paciente getFirst();
    List <Paciente> findAll();
    Paciente buildPacientefromDTO(PacienteDTO pacienteDTO);
    Double facturar (Paciente paciente);
}
