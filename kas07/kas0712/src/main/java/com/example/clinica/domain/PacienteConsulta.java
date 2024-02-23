package com.example.clinica.domain;

import com.example.clinica.config.Tarifas;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "CONSULTA")
@Entity
public class PacienteConsulta extends Paciente{
    private String motivoConsulta;

    @Override
    public Double facturar(Tarifas tarifas){
        return tarifas.getTarifaConsulta();
    }
}
