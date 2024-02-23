package com.example.kas07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Proyecto;

public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{
    
}
