package com.example.bank.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MovimientoDto {
    private LocalDateTime fecha;
    private double cantidad;
}
