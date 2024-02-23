package com.example.clinica.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.example.clinica.config.Tarifas;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "REVISION")
@Entity
public class PacienteRevision extends Paciente{
    private LocalDate fechaUltimaRevision;

    @Override
    public Double facturar(Tarifas tarifas){
        long edad = ChronoUnit.YEARS.between(this.fechaUltimaRevision, LocalDate.now());
        if(edad < 65){
            return tarifas.getTarifaRevisionAdulto();
        }else return tarifas.getTarifaRevisionJubilado();
    }
}

