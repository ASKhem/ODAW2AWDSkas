package com.example.kas07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Kas0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas0601Application.class, args);
	}

	// @Bean
	// public CommandLineRunner initData(HelperService<Empleado> empleadoService,
	// 		HelperService<Categoria> categoriaService, HelperService<Departamento> departamentoService,
	// 		EmpleadoProyectoService empleadoProyectoService, HelperService<Proyecto> proyectoService) {
	// 	return (args) -> {
	// 		String[] departamentos = { "Base de datos", "Inteligencia artificial", "Desarrollo web" };
	// 		String[] categorias = { "Junior", "Senior", "Jefe de proyecto" };
	// 		String[] proyectos = { "Proyecto 1", "Proyecto 2", "Proyecto 3" };
	// 		// puesto tipicos en una empresa de desarrollo software
	// 		String[] puestos = { "Programador", "Analista", "Diseñador", "Tester", "Jefe de proyecto" };
	// 		Random random = new Random();

	// 		// nombres intercalados de hombre y mujer
	// 		String[] nombres = { "Juan", "Ana", "Pedro", "Maria", "Luis", "Sara" };
	// 		for (int i = 0; i < 3; i++) {
	// 			departamentoService.añadir(new Departamento(0L, departamentos[i]));
	// 			categoriaService.añadir(new Categoria(0L, categorias[i], null));
	// 			proyectoService.añadir(new Proyecto(0L, proyectos[i]));
	// 		}
	// 		for (int i = 0; i < 6; i++) {
	// 			Long departamento = random.nextLong(3) + 1;
	// 			Long categoria = random.nextLong(3) + 1;
	// 			double salario;
	// 			if (categoria == 1) {
	// 				salario = Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
	// 			} else if (categoria == 2) {
	// 				salario = Math.round((Math.random() * 1000 + 2000) * 100.0) / 100.0;
	// 			} else {
	// 				salario = Math.round((Math.random() * 1000 + 3000) * 100.0) / 100.0;
	// 			}
	// 			// Math.round((Math.random() * 1000 + 1000) * 100.0) / 100.0;
	// 			Genero genero = (i % 2 == 0) ? Genero.HOMBRE : Genero.MUJER;
	// 			String imagen = (i % 2 == 0) ? "/empleadoFotoPerfil/empleadoM.png"
	// 					: "/empleadoFotoPerfil/empleadoF.png";
	// 			empleadoService.añadir(new Empleado(0L, departamentoService.obtenerPorId(departamento),
	// 					categoriaService.obtenerPorId(categoria), nombres[i], nombres[i] + i + "@gmail.com", salario,
	// 					true, genero, imagen));
	// 		}

	// 		// Un para de relaciones entre empleados y proyectos
	// 		List<Empleado> empleados = empleadoService.obtenerTodos();
	// 		List<Proyecto> proyectoss = proyectoService.obtenerTodos();

	// 		for (Empleado empleado : empleados) {
	// 			// Obtener dos proyectos aleatorios para asignar al empleado
	// 			List<Proyecto> proyectosAsignados = new ArrayList<>();
	// 			for (int i = 0; i < 2; i++) {
	// 				Proyecto proyectoAsignado;
	// 				do {
	// 					proyectoAsignado = proyectoss.get(random.nextInt(proyectoss.size()));
	// 				} while (proyectosAsignados.contains(proyectoAsignado));
	// 				proyectosAsignados.add(proyectoAsignado);

	// 				String puesto = puestos[random.nextInt(puestos.length)];

	// 				EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto();
	// 				empleadoProyecto.setEmpleado(empleado);
	// 				empleadoProyecto.setProyecto(proyectoAsignado);
	// 				empleadoProyecto.setPuesto(puesto);

	// 				empleadoProyectoService.añadir(empleadoProyecto);
	// 			}
	// 		}
	// 	};
	// }

}
