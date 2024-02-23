package com.example.kas07;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kas07.domain.Categoria;
import com.example.kas07.domain.Producto;
import com.example.kas07.domain.TipoIva;
import com.example.kas07.services.CategoriaService;
import com.example.kas07.services.ProductoService;



@SpringBootApplication
public class Kas07Application {


	public static void main(String[] args) {
		SpringApplication.run(Kas07Application.class, args);
	}

    @Bean
    public CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
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
        };
    }
	

}
