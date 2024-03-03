package kas1006a.kas10.kas0601;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kas1006a.kas10.kas0601.domain.Empleado;
import kas1006a.kas10.kas0601.services.EmpleadoService;

@SpringBootApplication
public class Kas0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas0601Application.class, args);
	}

	//instanciar empleados para probar el programa
	@Bean
	public CommandLineRunner initData(EmpleadoService empleadoService) {
		return (args) -> {
			for(int i=0;i<5;i++){
				Empleado empleado = new Empleado();
				empleado.setId((long) i);
				empleado.setNombre("Nombre"+i);
				empleado.setEmail("email"+i+"@gmail.com");
				empleado.setSalario((double)1000+i+Math.random()*1000);
				empleadoService.añadir(empleado);
			}
		};
	}

}
