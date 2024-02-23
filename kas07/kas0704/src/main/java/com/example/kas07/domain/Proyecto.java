package com.example.kas07.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor//añadido
@AllArgsConstructor//añadido
public class Proyecto {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
}
