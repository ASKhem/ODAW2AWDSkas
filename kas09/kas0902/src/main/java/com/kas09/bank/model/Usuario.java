package com.kas09.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;


    @Column(unique = true)
    @NotEmpty
    private String nombre;

    //contraseña minimo 4 caracteres
    @Size(min = 4)
    private String password;

    private Rol rol;
}
