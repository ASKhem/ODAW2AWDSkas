package com.example.bank;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bank.model.Cuenta;
import com.example.bank.model.Movimiento;
import com.example.bank.service.CuentaService;
import com.example.bank.service.MovimientoService;

@SpringBootApplication
public class Kas07Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas07Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(CuentaService cuentaService, MovimientoService movimientoService) {
		return (args) -> {
			Random rand = new Random();
			for (int i = 1; i <= 4; i++) {
				Cuenta cuenta = new Cuenta("ES662100041840123456784" + i, "Cuenta " + i);
				cuenta = cuentaService.createCuenta(cuenta);
	
				for (int j = 0; j < 4; j++) {
					double cantidad = rand.nextInt(1000) - 300;
					cuentaService.updateSaldo(cuenta, cantidad);
					cuenta = cuentaService.getCuenta(cuenta.getIBAN());
					Movimiento movimiento = new Movimiento(0L, cuenta, LocalDateTime.now(), cantidad);
					movimientoService.createMovimiento(cuenta, movimiento);
				}
			}
		};
	}

}
