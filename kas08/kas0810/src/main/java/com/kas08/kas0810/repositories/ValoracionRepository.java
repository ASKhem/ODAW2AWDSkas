package com.kas08.kas0810.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kas08.kas0810.domain.Producto;
import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.domain.Valoracion;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByUsuario(Usuario usuario);
    List<Valoracion> findByProducto(Producto producto);
    Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
}
