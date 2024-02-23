package com.example.kas0601.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas0601.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
