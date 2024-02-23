package com.example.kas07.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Producto {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nombre;

    private boolean enOferta;

    private TipoIva tipoIva;

    private Double precio;

    @ManyToOne
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Categoria categoria;

}
