package com.kas08.kas0802.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kas08.kas0802.services.CalculosServiceImpl;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    Random random = new Random();
    @Autowired
    CalculosServiceImpl calculosService;


    @GetMapping("/primo/{num}")
    public ResponseEntity<Boolean> showPrimo(@PathVariable Integer num){
        return ResponseEntity.ok(calculosService.calcularPrimo(num));
    }

    @GetMapping("/hipotenusa/{X}/{Y}")
    public ResponseEntity<?> showHipotenusa(@PathVariable Integer X, @PathVariable Integer Y){
        return ResponseEntity.ok(calculosService.calcularHipotenusa(X, Y));
    }

    @GetMapping("/sinRepetidos/{X}")
    public ResponseEntity<?> showSinRepetidos(@PathVariable Integer X){
        return ResponseEntity.ok(calculosService.calcularRepetidos(X));
    }

    @GetMapping("/divisores/{X}")
    public ResponseEntity<?> showDivisores(@PathVariable Integer X){
        return ResponseEntity.ok(calculosService.calculoDivisores(X));
    }
}
