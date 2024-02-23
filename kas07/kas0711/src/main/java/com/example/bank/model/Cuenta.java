package com.example.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Cuenta {
    @Id
    @Size(min = 24, max = 24, message = "*El IBAN debe de tener 24 caracteres")
    private String IBAN;

    @NotEmpty(message = "*Escribe un alias")
    private String alias;

    private double saldo;

    public Cuenta(String iban, String alias) {
        this.IBAN = iban;
        this.alias = alias;
        this.saldo = 0;
    }
}