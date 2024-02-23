package com.example.clinica.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO {
    @Size(min = 9, max = 9)
    private String dni;

    @Size(min = 3, max = 50)
    private String nombre;
    private Integer tipoPaciente;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private String motivoConsulta;
    private Integer ListaMedicamentos;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaUltimaRevision;
}
