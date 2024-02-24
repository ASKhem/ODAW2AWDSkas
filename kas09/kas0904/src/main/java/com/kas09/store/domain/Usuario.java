package com.kas09.store.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
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

    private LocalDate fechaRegistro;

    private String password;

    private Rol rol;
}
