package com.kas09.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.store.domain.Producto;
import com.kas09.store.domain.Usuario;
import com.kas09.store.domain.Valoracion;
import com.kas09.store.repositories.ValoracionRepository;

@Service
public class ValoracionServiceImplBD implements ValoracionService{
    @Autowired
    ValoracionRepository repository;

    public Valoracion findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Valoracion createValoracion(Valoracion Valoracion) {
        return repository.save(Valoracion);
    }

    public Boolean deleteValoracion(Valoracion Valoracion, String currentUsername) {
        if(Valoracion.getUsuario().getNombre().equals(currentUsername)){
            repository.delete(Valoracion);
            return true;
        }
        return false;
    }

    public List<Valoracion> findByUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    public List<Valoracion> findByProducto(Producto producto) {
        return repository.findByProducto(producto);
    }

    public Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto) {
        return repository.findByUsuarioAndProducto(usuario, producto);
    }

    public Valoracion updateValoracion(Valoracion Valoracion) {
        return repository.save(Valoracion);
    }

    
}
