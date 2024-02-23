package com.example.kas07.services;


import java.util.List;

import com.example.kas07.domain.Producto;
import com.example.kas07.domain.Usuario;
import com.example.kas07.domain.Valoracion;

public interface ValoracionService {
    public Valoracion findById(Long id);
    public Valoracion createValoracion(Valoracion Valoracion);
    public void deleteValoracion(Valoracion Valoracion);
    public List<Valoracion> findByUsuario(Usuario usuario);
    public List<Valoracion> findByProducto(Producto producto);
    public Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto);
    public Valoracion updateValoracion(Valoracion Valoracion);
}

