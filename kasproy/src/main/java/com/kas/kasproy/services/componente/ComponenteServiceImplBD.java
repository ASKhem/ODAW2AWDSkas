package com.kas.kasproy.services.componente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.model.product.Componente;
import com.kas.kasproy.repositories.ComponenteRepository;

@Service
public class ComponenteServiceImplBD implements ComponenteService{
    @Autowired
    ComponenteRepository componenteRepository;

    public List<Componente> getComponentes(){
        return componenteRepository.findAll();
    }
    public Componente getComponente(Long id){
        return componenteRepository.findById(id).get();
    }
    public Componente createComponente(Componente componente){
        return componenteRepository.save(componente);
    }
    public void deleteComponente(Long id){
        componenteRepository.deleteById(id);
    }
    public Componente updateComponente(Long id, Componente componente){
        componente.setId(id);
        return componenteRepository.save(componente);
    }
}