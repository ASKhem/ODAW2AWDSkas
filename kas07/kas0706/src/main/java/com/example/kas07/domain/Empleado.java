package com.example.kas07.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "DEPTO_ID", foreignKey = @ForeignKey(name="DEPTO_ID_FK")) // opcional
    private Departamento departamento;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID") // opcional
    private Categoria categoria;

    @NotEmpty
    private String nombre;

    @Email
    private String email;

    @NotNull
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    private String imagen = "/empleadoFotoPerfil/empleadoM.png";
}
