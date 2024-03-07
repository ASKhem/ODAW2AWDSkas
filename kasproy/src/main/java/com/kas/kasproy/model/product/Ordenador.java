package com.kas.kasproy.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ordenador {
    @Id
    @GeneratedValue
    private Long id;
    private String caja;
    private String placa;
    private String procesador;
    private String ram;
    private Integer modulosRam;
    private String almacenamiento;
    private Integer modulosAlmacenamiento;
    private String fuente;
    private String tarjeta;

}
