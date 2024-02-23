package com.example.kas07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
    Departamento findByNombre(String nombre);
}
