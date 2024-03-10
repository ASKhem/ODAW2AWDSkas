package com.kas.kasproy;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas.kasproy.dto.OrdenadorNewDto;
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
	public CommandLineRunner initData(UsuarioService usuarioService, PedidoService pedidoService,
			OrdenadorService ordenadorService, ComponenteService componenteService) {
		return (args) -> {
			UsuarioNewStandardDto user1 = new UsuarioNewStandardDto("usuario1", "usuario1234", "usuario1@gmail.com");
			UsuarioNewDto user2 = new UsuarioNewDto("admin1", "admin1234", "admin1@gmail.com", Rol.ADMIN);
			UsuarioNewDto user3 = new UsuarioNewDto("editor1", "editor1234", "editor1@gmail.com", Rol.EDITOR);
			usuarioService.createEstandardUsuario(user1);
			usuarioService.createUsuario(user2);
			usuarioService.createUsuario(user3);

			OrdenadorNewDto ordenador1 = new OrdenadorNewDto("h510", "ROG Strix B550-F Gaming", "ryzen-5 3600", "Corsair Vengeance LPX 16GB", "Samsung 970 EVO Plus 1TB NVMe PCIe M.2 SSD", "txm-series", "rtx-3060");
			OrdenadorNewDto ordenador2 = new OrdenadorNewDto("icue-220t", "MSI MPG Z490 Gaming Carbon WiFi", "i7-10700", "Kingston HyperX Fury 16GB", "WD Blue SN550 500GB NVMe PCIe M.2 SSD", "supernova", "rtx-3070");
			OrdenadorNewDto ordenador3 = new OrdenadorNewDto("view-51", "Gigabyte X570 AORUS Elite", "ryzen-9 5900X", "G.Skill Ripjaws V 32GB", "Kingston A2000 500GB NVMe PCIe M.2 SSD", "focus-gold", "rx-6800");
			OrdenadorNewDto ordenador4 = new OrdenadorNewDto("h510", "MSI MAG B550 Tomahawk", "ryzen-7 3700X", "Kingston HyperX Predator RGB 32GB", "Samsung 870 EVO 500GB SATA III SSD", "txm-series", "rtx-3080");
			
			ordenadorService.createOrdenador(ordenadorService.convertToOrdenador(ordenador1));
			ordenadorService.createOrdenador(ordenadorService.convertToOrdenador(ordenador2));
			ordenadorService.createOrdenador(ordenadorService.convertToOrdenador(ordenador3));
			ordenadorService.createOrdenador(ordenadorService.convertToOrdenador(ordenador4));

			Pedido pedido1 = new Pedido(1L,usuarioService.findById(1L),ordenadorService.getOrdenador(1L),ordenadorService.calcularPrecio(componenteService.getcomponentesOrdenador(ordenador1)),LocalDateTime.now());
			Pedido pedido2 = new Pedido(2L, usuarioService.findById(2L), ordenadorService.getOrdenador(2L), ordenadorService.calcularPrecio(componenteService.getcomponentesOrdenador(ordenador2)), LocalDateTime.now());
			Pedido pedido3 = new Pedido(3L, usuarioService.findById(3L), ordenadorService.getOrdenador(3L), ordenadorService.calcularPrecio(componenteService.getcomponentesOrdenador(ordenador3)), LocalDateTime.now());
			Pedido pedido4 = new Pedido(4L, usuarioService.findById(1L), ordenadorService.getOrdenador(4L), ordenadorService.calcularPrecio(componenteService.getcomponentesOrdenador(ordenador4)), LocalDateTime.now());

			pedidoService.createPedido(pedido1);
			pedidoService.createPedido(pedido2);
			pedidoService.createPedido(pedido3);
			pedidoService.createPedido(pedido4);

			System.out.println("Data initialized");

		};
	}

}
