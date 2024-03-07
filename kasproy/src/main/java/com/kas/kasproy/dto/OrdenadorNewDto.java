package com.kas.kasproy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrdenadorNewDto {
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
