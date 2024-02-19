package com.example.kas0601.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kas0601.dto.FormInfo;
import com.example.kas0601.services.CambioService;

import jakarta.validation.Valid;

@Controller
public class CambioController {
    @Autowired
    public CambioService cambioService;

    @GetMapping({"/" })
    public String showList(@RequestParam (required = false) Integer error,Model model) {
        if (error != null) {
            if (error == 1) model.addAttribute("error", "Debe ingresar un importe");
            if (error == 2) model.addAttribute("error", "No se pudo obtener la tasa de cambio");
        }
        model.addAttribute("formInfo", new FormInfo());
        return "indexView";
    }

    @PostMapping("/cambioMoneda")
    public String showNew(@Valid FormInfo formInfo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())  return "redirect:/";
        Double importeCambiado;
        try {
            importeCambiado = cambioService.calcularImporteCambiado(
                formInfo.getImporte(), formInfo.getMonedaOrigen(), formInfo.getMonedaDestino()
            );
        } catch (RuntimeException e) {
            return "redirect:/?err=2";
        }

        model.addAttribute("importeCambiado", importeCambiado);
        return "/resultView";
    }

}
