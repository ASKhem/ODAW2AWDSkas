package com.kas09.bank;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.model.Movimiento;
import com.kas09.bank.model.Rol;
import com.kas09.bank.model.Usuario;
import com.kas09.bank.service.CuentaService;
import com.kas09.bank.service.MovimientoService;
import com.kas09.bank.service.UserService;

@SpringBootApplication
public class Kas09Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas09Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(CuentaService cuentaService, MovimientoService movimientoService, UserService userService) {
		return (args) -> {
			Usuario user1 = new Usuario(0L, "admin1", "admin1234", Rol.ADMIN);
			userService.createUser(user1);
			Usuario user2 = new Usuario(0L, "user1", "user1234", Rol.USER);
			userService.createUser(user2);
			userService.createUser(user2);
			Usuario user3 = new Usuario(0L, "owner1", "owner1234", Rol.OWNER);
			userService.createUser(user3);
			Usuario user4 = new Usuario(0L, "owner2", "owner1234", Rol.OWNER);
			userService.createUser(user4);
			Usuario user5 = new Usuario(0L, "admin2", "admin1234", Rol.ADMIN);
			userService.createUser(user5);
			Usuario user6 = new Usuario(0L, "user2", "user1234", Rol.USER);
			userService.createUser(user6);

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
