package com.example.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.bank.dtos.MovimientoDto;
import com.example.bank.dtos.NewMovimientoDto;
import com.example.bank.exceptions.AmountOutOfRangeException;
import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;
import com.example.bank.service.CuentaService;
import com.example.bank.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @Autowired
    CuentaService cuentaService;
    
    @GetMapping("/{iban}/list")
    public ResponseEntity<?> listMovimientos(@PathVariable String iban) {
        List <MovimientoDto> movimientos = movimientoService.getMovimientosDto(movimientoService.getMovimientos(cuentaService.getCuenta(iban)));
        return ResponseEntity.ok(movimientos); 
    }

    @PostMapping("/newMovement")
    public ResponseEntity<?> createMovimiento(@RequestBody NewMovimientoDto movimientoDto) {
        Cuenta cuenta = cuentaService.getCuenta(movimientoDto.getIBAN());
        try {
            Movimiento movimiento = movimientoService.convertDtoToMovimiento(movimientoDto, cuenta);
            movimientoService.createMovimiento(cuenta, movimiento);
            cuentaService.updateSaldo(cuenta, movimiento.getCantidad());
            return ResponseEntity.status(HttpStatus.CREATED).body(movimiento);
        }catch(AmountOutOfRangeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
