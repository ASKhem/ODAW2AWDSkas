package com.kas08.kas0802.controller;

import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<Map<?,?>> showPrimo(@PathVariable Integer num){
        //crearemos un objeto de tipo Map para almacenar los datos que vamos a devolver
        //en su 
        Map<String, Object> response = new HashMap<>();
        response.put("Numero", num);
        response.put("Primo", calculosService.calcularPrimo(num));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hipotenusa/{X}/{Y}")
    public ResponseEntity<Map<?,?>>  showHipotenusa(@PathVariable Integer X, @PathVariable Integer Y){
        Map<String, Object> response = new HashMap<>();
        response.put("X", X);
        response.put("Y", Y);
        response.put("Hipotenusa", calculosService.calcularHipotenusa(X, Y));
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/sinRepetidos/{X}")
    public ResponseEntity<Map<?,?>>  showSinRepetidos(@PathVariable Integer X){
        Map<String, Object> response = new HashMap<>();
        response.put("Números a generar", X);
        response.put("Números generados", calculosService.calcularRepetidos(X));
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/divisores/{X}")
    public ResponseEntity<Map<?,?>>  showDivisores(@PathVariable Integer X){
        Map<String, Object> response = new HashMap<>();
        response.put("Número", X);
        response.put("Divisores", calculosService.calculoDivisores(X));
        return ResponseEntity.ok(response);
    }
}
