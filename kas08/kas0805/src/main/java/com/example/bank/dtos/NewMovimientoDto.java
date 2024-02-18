package com.example.bank.dtos;

import lombok.Data;

@Data
public class NewMovimientoDto {
    private String IBAN;
    private double cantidad;
}
