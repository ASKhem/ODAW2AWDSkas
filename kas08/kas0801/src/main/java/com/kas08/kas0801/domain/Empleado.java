package com.kas08.kas0801.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Empleado {
    @Id
    @GeneratedValue
    @Min(value = 0)
    private Long id;
    @NotEmpty
    private String nombre;
    @Email
    private String email;
    @NotNull
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    //añadimos una imagen para cada empleado por defecto
    private String imagen = "/empleadoFotoPerfil/empleadoM.png";
}

