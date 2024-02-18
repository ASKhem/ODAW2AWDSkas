package com.example.bank.dtos;

import lombok.Data;

@Data
public class NewCuentaDto {
    private String IBAN;
    private String alias;
}
