package com.example.kas07;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kas07.domain.Categoria;
import com.example.kas07.domain.Departamento;
import com.example.kas07.domain.Empleado;
import com.example.kas07.domain.Genero;
import com.example.kas07.services.HelperService;


@SpringBootApplication
public class Kas0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas0601Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(HelperService<Empleado> empleadoService, HelperService<Categoria> categoriaService, HelperService<Departamento> departamentoService) {
		return (args) -> {
			String [] departamentos = {"Base de datos", "Inteligencia artificial", "Desarrollo web"};
			String [] categorias = {"Junior", "Senior", "Jefe de proyecto"};
			//nombres intercalados de hombre y mujer
			String [] nombres = {"Juan", "Ana", "Pedro", "Maria", "Luis", "Sara"};
			for(int i=0;i<3;i++){
				departamentoService.añadir(new Departamento(0L, departamentos[i]));
				categoriaService.añadir(new Categoria(0L, categorias[i], null));	
			}
			Random random = new Random();
			for(int i=0;i<6;i++){
				Long departamento = random.nextLong(3) + 1;
				Long categoria = random.nextLong(3) + 1;
				double salario;
				if(categoria==1){
					salario = Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
				}else if(categoria==2){
					salario = Math.round((Math.random() * 1000 + 2000) * 100.0) / 100.0;
				}else{
					salario = Math.round((Math.random() * 1000 + 3000) * 100.0) / 100.0;
				}
				// Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
				Genero genero = (i%2==0)?Genero.HOMBRE:Genero.MUJER;
				String imagen = (i%2==0)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
				empleadoService.añadir(new Empleado(0L,departamentoService.obtenerPorId(departamento), categoriaService.obtenerPorId(categoria),nombres[i], nombres[i]+i+"@gmail.com",salario, true, genero, imagen));
			}
		};
	}

}
