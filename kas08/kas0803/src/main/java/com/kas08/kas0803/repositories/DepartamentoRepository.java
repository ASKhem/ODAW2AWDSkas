package com.kas08.kas0803.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas08.kas0803.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
    Departamento findByNombre(String nombre);
}
