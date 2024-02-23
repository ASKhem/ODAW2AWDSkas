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
@DiscriminatorValue(value = "RECETA")
@Entity
public class PacienteRecetas extends Paciente{
    private Integer listaMedicamentos;

    @Override
    public Double facturar(Tarifas tarifas){
        return tarifas.getTarifaReceta() * listaMedicamentos;
    }
}
