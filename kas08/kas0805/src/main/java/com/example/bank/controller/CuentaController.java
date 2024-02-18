package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.bank.dtos.NewCuentaDto;
import com.example.bank.exceptions.EmptyAccountsListException;
import com.example.bank.exceptions.NotEmptyMovementsAccount;
import com.example.bank.exceptions.NotFoundAccountException;
import com.example.bank.model.Cuenta;
import com.example.bank.service.CuentaService;
import com.example.bank.service.MovimientoService;



@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/list")
    public ResponseEntity<?> showCuentas(){
        try{
            return ResponseEntity.ok(cuentaService.getCuentas());
        }catch(EmptyAccountsListException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCuenta(@RequestBody NewCuentaDto newCuenta, BindingResult bindingResult){
        Cuenta cuenta = cuentaService.convertDtoToCuenta(newCuenta);
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cuenta no válida");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.createCuenta(cuenta));
        }
    }


    @DeleteMapping("/{iban}/delete")
    public ResponseEntity<?> deleteCuenta(@PathVariable String iban) {
        boolean movimientos = movimientoService.getMovimientos(cuentaService.getCuenta(iban)).size() > 0;
        try {
            cuentaService.deleteCuenta(iban, movimientos);
            return ResponseEntity.noContent().build();
        } catch (NotEmptyMovementsAccount e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (NotFoundAccountException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // @PutMapping("/edit")
    // public ResponseEntity<?> editCuenta(@RequestBody @Valid Cuenta cuenta, BindingResult bindingResult) {
    //     if (bindingResult.hasErrors()) {
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cuenta no válida");
    //     } else {
    //         return ResponseEntity.ok(cuentaService.editCuenta(cuenta));
    //     }
    // }

}
