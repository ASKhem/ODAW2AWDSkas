package com.kas09.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.model.Movimiento;
import com.kas09.bank.repositories.MovimientoRepository;

@Service
public class MovimientoServiceImplBD implements MovimientoService{
    
    @Autowired
    public MovimientoRepository movimientoRepository;

    public List<Movimiento> getMovimientos(Cuenta cuenta) {
        return movimientoRepository.findByCuenta(cuenta);
    }

    public Double createMovimiento(Cuenta cuenta, Movimiento movimiento, String rol) {
        System.out.println(rol);
        if (rol.equals("[ROLE_USER]") && movimiento.getCantidad() < 0) {
            return null;
        } else {
            movimiento.setCuenta(cuenta);
            movimientoRepository.save(movimiento);
            return movimiento.getCantidad();
        }
    }

}
