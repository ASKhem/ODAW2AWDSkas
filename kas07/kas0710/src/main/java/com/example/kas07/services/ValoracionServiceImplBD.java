package com.example.kas07.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kas07.domain.Producto;
import com.example.kas07.domain.Usuario;
import com.example.kas07.domain.Valoracion;
import com.example.kas07.repositories.ValoracionRepository;

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

    public void deleteValoracion(Valoracion Valoracion) {
        repository.delete(Valoracion);  
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
