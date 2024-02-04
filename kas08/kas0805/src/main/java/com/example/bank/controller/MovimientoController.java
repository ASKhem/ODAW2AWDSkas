package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bank.model.Movimiento;
import com.example.bank.service.CuentaService;
import com.example.bank.service.MovimientoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @Autowired
    CuentaService cuentaService;
    
    @GetMapping("/{iban}/list")
    public String listMovimientos(@PathVariable String iban, Model model) {
        model.addAttribute("movimientos", movimientoService.getMovimientos(cuentaService.getCuenta(iban)));
        model.addAttribute("iban", iban);
        return "movementsList";
    }

    @GetMapping("/{iban}/newMovement")
    public String createMovimiento(@PathVariable String iban, Model model) {
        model.addAttribute("movimiento", new Movimiento());
        model.addAttribute("iban", iban);
        return "newMovement";
    }

    @PostMapping("/{iban}/newMovement/submit")
    public String createMovimientoSubmit(@PathVariable String iban, @Valid Movimiento movimiento, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newMovement";
        }else{
            movimientoService.createMovimiento(cuentaService.getCuenta(iban),movimiento);
            cuentaService.updateSaldo(cuentaService.getCuenta(iban), movimiento.getCantidad());
            return "redirect:/movimientos/" + iban + "/list";
        }
    }
}
