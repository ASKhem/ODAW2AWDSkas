package com.kas09.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.store.domain.Producto;
import com.kas09.store.domain.Usuario;
import com.kas09.store.domain.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long>{
    List<Valoracion> findByUsuario(Usuario usuario);
    List<Valoracion> findByProducto(Producto producto);
    Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
}
