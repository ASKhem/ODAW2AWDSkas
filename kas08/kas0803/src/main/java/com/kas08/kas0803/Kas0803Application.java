package com.kas08.kas0803;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas08.kas0803.domain.Departamento;
import com.kas08.kas0803.domain.Empleado;
import com.kas08.kas0803.domain.Genero;
import com.kas08.kas0803.services.DepartamentoService;
import com.kas08.kas0803.services.EmpleadoService;


@SpringBootApplication
public class Kas0803Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas0803Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(EmpleadoService empleadoService, DepartamentoService departamentoService) {
		return (args) -> {
			for(int i=1;i<4;i++){
				departamentoService.añadir(new Departamento(0L, "departamento"+i));
			}
			Random random = new Random();
			for(int i=0;i<6;i++){
				int departamento = random.nextInt(3) + 1;
				double salario = Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
				Genero genero = (i%2==0)?Genero.HOMBRE:Genero.MUJER;
				String imagen = (i%2==0)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
				empleadoService.añadir(new Empleado(0L,departamentoService.obtenerPorId(departamento),"empleado"+i, "correo"+i+"@gmail.com",salario, true, genero, imagen));
			}
		};
	}

}
