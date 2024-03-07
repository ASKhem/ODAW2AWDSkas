package com.kas.kasproy;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas.kasproy.model.Pedido;
import com.kas.kasproy.model.product.Ordenador;
import com.kas.kasproy.model.user.Rol;
import com.kas.kasproy.model.user.Usuario;
import com.kas.kasproy.services.ordenador.OrdenadorService;
import com.kas.kasproy.services.pedido.PedidoService;
import com.kas.kasproy.services.usuario.UsuarioService;

@SpringBootApplication
public class KasproyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KasproyApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioService usuarioService, PedidoService pedidoService, OrdenadorService ordenadorService) {
		return (args) -> {
			Usuario user1 = new Usuario();
			user1.setNombre("usuario1");
			user1.setFechaRegistro(LocalDate.now());
			user1.setPassword("usuario1234");
			user1.setEmail("usuario1@gmail.com");
			user1.setRol(Rol.COSTUMER);
			user1.setSaved(new ArrayList<>());

			Usuario user2 = new Usuario();
			user2.setNombre("admin1");
			user2.setFechaRegistro(LocalDate.now());
			user2.setPassword("admin1234");
			user2.setEmail("admin1@gmail.com");
			user2.setRol(Rol.ADMIN);
			user2.setSaved(new ArrayList<>());

			Usuario user3 = new Usuario();
			user3.setNombre("editor1");
			user3.setFechaRegistro(LocalDate.now());
			user3.setPassword("editor1234");
			user3.setEmail("editor1@gmail.com");
			user3.setRol(Rol.EDITOR);
			user3.setSaved(new ArrayList<>());

			usuarioService.createUsuario(user1);
			usuarioService.createUsuario(user2);
			usuarioService.createUsuario(user3);

			System.out.println("Usuarios creados: " + usuarioService.getUsuarios());

			Ordenador ordenador1 = new Ordenador(1L, "caja1", "placa1", "procesador1", "ram1", 2, "almacenamiento1", 1, "fuente1", "tarjeta1");
			ordenadorService.createOrdenador(ordenador1);
			
			Pedido pedido1 = new Pedido(1L, user1, ordenador1, 2000.0D);
			pedidoService.createPedido(pedido1);
			System.out.println("Pedidos creados: " + pedidoService.getPedidos());
		};
	}

}
