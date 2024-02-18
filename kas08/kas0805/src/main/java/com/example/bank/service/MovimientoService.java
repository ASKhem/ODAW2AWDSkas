package com.example.bank.service;

import java.util.List;

import com.example.bank.dtos.MovimientoDto;
import com.example.bank.dtos.NewMovimientoDto;
import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;

public interface MovimientoService {
    public List<Movimiento> getMovimientos(Cuenta cuenta);
    public Double createMovimiento(Cuenta cuenta, Movimiento movimiento);
    public List<MovimientoDto> getMovimientosDto(List<Movimiento> movimientos);
    public Movimiento convertDtoToMovimiento(NewMovimientoDto movimientoDto, Cuenta cuenta);
}
