package com.example.kas1006c;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kas1006c.domain.Empleado;
import com.example.kas1006c.domain.Genero;
import com.example.kas1006c.services.EmpleadoService;

@SpringBootApplication
public class Kas10Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas10Application.class, args);
	}

	//instanciar empleados para probar el programa
	@Bean
	public CommandLineRunner initData(EmpleadoService empleadoService) {
		return (args) -> {
			for(int i=0;i<4;i++){
				double salario = Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
				Genero genero = (i%2==0)?Genero.HOMBRE:Genero.MUJER;
				String imagen = (i%2==0)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
				empleadoService.añadir(new Empleado(0L,"empleado"+i, "correo"+i+"@gmail.com",salario, true, genero, imagen));
			}
		};
	}

}
