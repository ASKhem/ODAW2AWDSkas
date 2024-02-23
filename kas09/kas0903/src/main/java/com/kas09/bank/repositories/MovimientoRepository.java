package com.kas09.bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
