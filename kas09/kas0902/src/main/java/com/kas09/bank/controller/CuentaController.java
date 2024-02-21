package com.kas09.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.service.CuentaService;
import com.kas09.bank.service.MovimientoService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/list")
    public String listCuentas(Model model) {
        model.addAttribute("cuentas", cuentaService.getCuentas());
        return "accountsList";
    }

    @GetMapping("/create")
    public String createCuenta(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "newAccount";
    }

    @PostMapping("/create/submit")
    public String createCuentaSubmit(@Valid Cuenta cuenta, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "newAccount";
        } else {
            cuentaService.createCuenta(cuenta);
            return "redirect:/cuentas/list";
        }
    }

    @GetMapping("/delete/{iban}")
    public String deleteCuenta(@PathVariable String iban) {
        if(cuentaService.getCuenta(iban) != null){
            cuentaService.deleteCuenta(iban);
        }
        return "redirect:/cuentas/list";
    }

    @GetMapping("/edit/{iban}")
    public String editCuenta(Model model, @PathVariable String iban) {
        model.addAttribute("cuenta", cuentaService.getCuenta(iban));
        return "accountEdit";
    }

    @PostMapping("/edit/submit")
    public String editCuentaSubmit(Cuenta cuenta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "accountEdit";
        } else {
            cuentaService.editCuenta(cuenta);
            return "redirect:/cuentas/list";
        }
    }




}
