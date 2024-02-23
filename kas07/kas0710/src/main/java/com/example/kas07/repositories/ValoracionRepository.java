package com.example.kas07.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kas07.domain.Producto;
import com.example.kas07.domain.Usuario;
import com.example.kas07.domain.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long>{
    List<Valoracion> findByUsuario(Usuario usuario);
    List<Valoracion> findByProducto(Producto producto);
    Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
}
