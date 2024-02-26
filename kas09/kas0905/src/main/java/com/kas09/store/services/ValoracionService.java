package com.kas09.store.services;


import java.util.List;

import com.kas09.store.domain.Producto;
import com.kas09.store.domain.Usuario;
import com.kas09.store.domain.Valoracion;

public interface ValoracionService {
    public Valoracion findById(Long id);
    public Valoracion createValoracion(Valoracion Valoracion);
    public Boolean deleteValoracion(Valoracion Valoracion, String currentUsername);
    public List<Valoracion> findByUsuario(Usuario usuario);
    public List<Valoracion> findByProducto(Producto producto);
    public Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
    public Valoracion updateValoracion(Valoracion Valoracion);
}

