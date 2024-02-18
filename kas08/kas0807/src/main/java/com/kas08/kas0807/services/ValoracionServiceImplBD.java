package com.kas08.kas0807.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas08.kas0807.domain.Producto;
import com.kas08.kas0807.domain.Usuario;
import com.kas08.kas0807.domain.Valoracion;
import com.kas08.kas0807.exceptions.GenericNotFoundException;
import com.kas08.kas0807.repositories.ValoracionRepository;

@Service
public class ValoracionServiceImplBD implements ValoracionService{
    @Autowired
    ValoracionRepository repository;

    public Valoracion findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException());
    }

    public Valoracion createValoracion(Valoracion Valoracion) {
        return repository.save(Valoracion);
    }

    public void deleteValoracion(Valoracion Valoracion) {
        if(repository.findById(Valoracion.getId()).isEmpty()) {
            throw new GenericNotFoundException();
        }
        repository.delete(Valoracion);  
    }

    public List<Valoracion> findByUsuario(Usuario usuario) {
        if(repository.findByUsuario(usuario).isEmpty()) {
            throw new GenericNotFoundException();
        }
        return repository.findByUsuario(usuario);
    }

    public List<Valoracion> findByProducto(Producto producto) {
        if(repository.findByProducto(producto).isEmpty()) {
            throw new GenericNotFoundException();
        }
        return repository.findByProducto(producto);
    }

    public Valoracion findByUsuarioAndProducto(Usuario usuario, Producto producto) {
        return repository.findByUsuarioAndProducto(usuario, producto);
    }

    public Valoracion updateValoracion(Valoracion Valoracion) {
        return repository.save(Valoracion);
    }
    
}
