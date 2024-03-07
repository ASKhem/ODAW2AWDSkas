package com.kas.kasproy.model.user;

import java.time.LocalDate;
import java.util.ArrayList;

import com.kas.kasproy.model.product.Ordenador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(name = "usuario", length = 20, unique = true)
    private String nombre;

    @NotNull
    private LocalDate fechaRegistro;

    @NotEmpty
    @Column(length = 20)
    private String password;

    @NotEmpty
    @Column(length = 30, unique = true)
    private String email;

    @NotNull
    private Rol rol;

    private ArrayList<Ordenador> cesta;
}
