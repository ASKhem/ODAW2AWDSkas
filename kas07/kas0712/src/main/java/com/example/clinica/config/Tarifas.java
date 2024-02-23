package com.example.clinica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:/config/tarifas.properties")
public class Tarifas {
    @Value("${tarifaConsulta}")
    private Double tarifaConsulta;
    
    @Value("${tarifaReceta}")
    private Double tarifaReceta;

    @Value("${tarifaRevisionAdulto}")
    private Double tarifaRevisionAdulto;

    @Value("${tarifaRevisionJubilado}")
    private Double tarifaRevisionJubilado;
}
