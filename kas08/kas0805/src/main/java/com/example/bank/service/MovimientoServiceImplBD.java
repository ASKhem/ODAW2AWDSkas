package com.example.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.dtos.MovimientoDto;
import com.example.bank.dtos.NewMovimientoDto;
import com.example.bank.exceptions.AmountOutOfRangeException;
import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;
import com.example.bank.repositories.MovimientoRepository;

@Service
public class MovimientoServiceImplBD implements MovimientoService{
    
    @Autowired
    public MovimientoRepository movimientoRepository;
    @Autowired
    public ModelMapper modelMapper;    

    public List<Movimiento> getMovimientos(Cuenta cuenta) {
        return movimientoRepository.findByCuenta(cuenta);
    }

    public List<MovimientoDto> getMovimientosDto(List<Movimiento> movimientos) {
        List<MovimientoDto> movimientosDto = new ArrayList<MovimientoDto>();
        for (Movimiento movimiento : movimientos) {
            movimientosDto.add(modelMapper.map(movimiento, MovimientoDto.class));
        }
        return movimientosDto;
    }

    public Double createMovimiento(Cuenta cuenta,Movimiento movimiento) {
        movimiento.setCuenta(cuenta);
        movimientoRepository.save(movimiento);
        return movimiento.getCantidad();
    }

    public Movimiento convertDtoToMovimiento(NewMovimientoDto movimientoDto, Cuenta cuenta){
        Movimiento movimiento = modelMapper.map(movimientoDto, Movimiento.class);
        if(movimientoDto.getCantidad() < -100 || movimientoDto.getCantidad() > 1000){
            throw new AmountOutOfRangeException(movimientoDto.getCantidad());
        }
        movimiento.setCuenta(cuenta);
        return movimiento;
    }

}
