package com.example.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;
import com.example.bank.repositories.MovimientoRepository;

@Service
public class MovimientoServiceImplBD implements MovimientoService{
    
    @Autowired
    public MovimientoRepository movimientoRepository;
        public List<Movimiento> getMovimientos(Cuenta cuenta) {
            return movimientoRepository.findByCuenta(cuenta);
        }

    public Double createMovimiento(Cuenta cuenta,Movimiento movimiento) {
        movimiento.setCuenta(cuenta);
        movimientoRepository.save(movimiento);
        return movimiento.getCantidad();
    }

}
