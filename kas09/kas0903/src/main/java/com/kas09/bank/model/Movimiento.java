package com.kas09.bank.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Movimiento {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Cuenta_IBAN")
    private Cuenta cuenta;
    private LocalDateTime fecha = LocalDateTime.now();
    @Min(value = -300, message = "*No puede retirar más de 300€")
    @Max(value = 1000, message = "*No puede ingresar más de 1000€")
    private double cantidad;
}
