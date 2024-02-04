package com.kas08.kas0803.dto;

import com.kas08.kas0803.domain.Genero;

import lombok.Data;

@Data
public class EmpleadosAddOrEditDTO {
    private Long id;
    private Long departamentoId;
    private String nombre;
    private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;
}
