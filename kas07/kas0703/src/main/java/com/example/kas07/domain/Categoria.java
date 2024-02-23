package com.example.kas07.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER, 
                cascade=CascadeType.REMOVE, 
                mappedBy = "categoria")
    private Set<Empleado> empleados = new HashSet<> ();
}
