package com.example.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
