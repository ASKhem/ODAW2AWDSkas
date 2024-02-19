package com.kas08.kas0810.services;


import java.util.List;

import com.kas08.kas0810.domain.Producto;
import com.kas08.kas0810.domain.Usuario;
import com.kas08.kas0810.domain.Valoracion;

public interface ValoracionService {
    public Valoracion findById(Long id);
    public Valoracion createValoracion(Valoracion Valoracion);
    public void deleteValoracion(Valoracion Valoracion);
    public List<Valoracion> findByUsuario(Usuario usuario);
    public List<Valoracion> findByProducto(Producto producto);
    public Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
    public Valoracion updateValoracion(Valoracion Valoracion);
}

