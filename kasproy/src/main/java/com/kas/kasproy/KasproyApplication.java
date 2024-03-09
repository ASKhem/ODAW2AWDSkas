package com.kas.kasproy;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas.kasproy.dto.UsuarioNewDto;
import com.kas.kasproy.dto.UsuarioNewStandardDto;
import com.kas.kasproy.model.Pedido;
import com.kas.kasproy.model.product.Ordenador;
import com.kas.kasproy.model.user.Rol;
import com.kas.kasproy.services.componente.ComponenteService;
import com.kas.kasproy.services.ordenador.OrdenadorService;
import com.kas.kasproy.services.pedido.PedidoService;
import com.kas.kasproy.services.usuario.UsuarioService;

@SpringBootApplication
public class KasproyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KasproyApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioService usuarioService, PedidoService pedidoService, OrdenadorService ordenadorService, ComponenteService componenteService) {
		return (args) -> {
			System.out.println("Componentes: " + componenteService.getComponentes());
			UsuarioNewStandardDto user1 = new UsuarioNewStandardDto("usuario1", "usuario1234", "usuario1@gmail.com");
			UsuarioNewDto user2 = new UsuarioNewDto("admin1", "admin1234", "admin1@gmail.com", Rol.ADMIN);
			UsuarioNewDto user3 = new UsuarioNewDto("editor1", "editor1234", "editor1@gmail.com", Rol.EDITOR);
			usuarioService.createEstandardUsuario(user1);
			usuarioService.createUsuario(user2);
			usuarioService.createUsuario(user3);

			System.out.println("Usuarios creados: " + usuarioService.getUsuarios());

			Ordenador ordenador1 = new Ordenador(1L, "caja1", "placa1", "procesador1", "ram1", "almacenamiento1", "fuente1", "tarjeta1");
			ordenadorService.createOrdenador(ordenador1);
			Ordenador ordenador2 = new Ordenador(2L, "caja2", "placa2", "procesador2", "ram2", "almacenamiento2", "fuente2", "tarjeta2");
			Pedido pedido2 = new Pedido(2L, usuarioService.findById(2L), ordenador2, 3000.0D, LocalDateTime.now());
			Pedido pedido1 = new Pedido(1L, usuarioService.findById(1L), ordenador1, 2000.0D, LocalDateTime.now());
			pedidoService.createPedido(pedido1);
			pedidoService.createPedido(pedido2);
			System.out.println("Pedidos creados: " + pedidoService.getPedidos());
		};
	}

}
