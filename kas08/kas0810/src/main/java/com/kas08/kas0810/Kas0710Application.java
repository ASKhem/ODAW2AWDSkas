package com.kas08.kas0810;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kas08.kas0810.domain.Categoria;
import com.kas08.kas0810.domain.Producto;
import com.kas08.kas0810.domain.TipoIva;
import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.domain.Valoracion;
import com.kas08.kas0810.services.CategoriaService;
import com.kas08.kas0810.services.ProductoService;
import com.kas08.kas0810.services.UsuarioService;
import com.kas08.kas0810.services.ValoracionService;



@SpringBootApplication
public class Kas0710Application {


	public static void main(String[] args) {
		SpringApplication.run(Kas0710Application.class, args);
	}

    @Bean
    public CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService, UsuarioService usuarioService, ValoracionService valoracionService) {
        return (args) -> {
            Categoria cat1 = new Categoria(0L, "Categoria 1");
            Categoria cat2 = new Categoria(0L, "Categoria 2");
            Categoria cat3 = new Categoria(0L, "Categoria 3");
            categoriaService.createCategoria(cat1);
            categoriaService.createCategoria(cat2);
            categoriaService.createCategoria(cat3);
            productoService.save(new Producto(0L, "Producto 1", false, TipoIva.NORMAL, 100.0, cat1));
            productoService.save(new Producto(0L, "Producto 2", true, TipoIva.REDUCIDO, 50.0, cat2));
            productoService.save(new Producto(0L, "Producto 3", false, TipoIva.SUPERREDUCIDO, 25.0, cat3));
            usuarioService.createUsuario(new Usuario(0L, "Usuario 1", LocalDate.now()));
            usuarioService.createUsuario(new Usuario(0L, "Usuario 2", LocalDate.now()));
            usuarioService.createUsuario(new Usuario(0L, "Usuario 3", LocalDate.now()));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(1L), productoService.findById(1L), 5, "Comentario 1"));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(2L), productoService.findById(2L), 4, "Comentario 2"));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(3L), productoService.findById(3L), 3, "Comentario 3"));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(1L), productoService.findById(2L), 2, "Comentario 4"));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(2L), productoService.findById(3L), 1, "Comentario 5"));
            valoracionService.createValoracion(new Valoracion(0L, usuarioService.findById(3L), productoService.findById(1L), 5, "Comentario 6"));
        };
    }
	

}
