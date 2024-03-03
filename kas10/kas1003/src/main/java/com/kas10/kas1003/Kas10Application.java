package com.kas10.kas1003;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.kas08.kas1003.domain.Empleado;
// import com.kas08.kas1003.domain.Genero;
// import com.kas08.kas1003.services.EmpleadoService;


@SpringBootApplication
public class Kas10Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas10Application.class, args);
	}

	// @Bean
	// CommandLineRunner initData(EmpleadoService empleadoService) {
	// 	return (args) -> {
	// 		for(int i=0;i<4;i++){
	// 			double salario = Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
	// 			Genero genero = (i%2==0)?Genero.HOMBRE:Genero.MUJER;
	// 			String imagen = (i%2==0)?"/empleadoFotoPerfil/empleadoM.png":"/empleadoFotoPerfil/empleadoF.png";
	// 			empleadoService.añadir(new Empleado(0L,"empleado"+i, "correo"+i+"@gmail.com",salario, true, genero, imagen));
	// 		}
	// 	};
	// }

}
