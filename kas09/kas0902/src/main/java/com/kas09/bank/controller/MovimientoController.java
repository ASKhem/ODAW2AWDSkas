package com.kas09.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas09.bank.model.Movimiento;
import com.kas09.bank.service.CuentaService;
import com.kas09.bank.service.MovimientoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @Autowired
    CuentaService cuentaService;
    
    @GetMapping("/list/{iban}")
    public String listMovimientos(@PathVariable String iban, Model model) {
        model.addAttribute("movimientos", movimientoService.getMovimientos(cuentaService.getCuenta(iban)));
        model.addAttribute("iban", iban);
        return "movementsList";
    }

    @GetMapping("/newMovement/{iban}")
    public String createMovimiento(@PathVariable String iban, Model model) {
        model.addAttribute("movimiento", new Movimiento());
        model.addAttribute("iban", iban);
        return "newMovement";
    }

    @PostMapping("/newMovement/submit/{iban}")
    public String createMovimientoSubmit(@PathVariable String iban, @Valid Movimiento movimiento, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newMovement";
        }else{
            movimientoService.createMovimiento(cuentaService.getCuenta(iban),movimiento);
            cuentaService.updateSaldo(cuentaService.getCuenta(iban), movimiento.getCantidad());
            return "redirect:/movimientos/list/"+ iban;
        }
    }
}
