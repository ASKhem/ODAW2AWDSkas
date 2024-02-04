package com.kas08.kas0803.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Empleado {
    @Id
    @GeneratedValue
    @Min(value = 0)
    private Long id;
    @ManyToOne
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Departamento departamento;
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

