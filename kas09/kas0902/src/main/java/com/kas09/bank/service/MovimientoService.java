package com.kas09.bank.service;

import java.util.List;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.model.Movimiento;

public interface MovimientoService {
    public List<Movimiento> getMovimientos(Cuenta cuenta);
    public Double createMovimiento(Cuenta cuenta, Movimiento movimiento);
}
