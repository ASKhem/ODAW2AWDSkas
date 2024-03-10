package com.kas.kasproy.services.componente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.dto.OrdenadorNewDto;
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
        return componenteRepository.save(componente);
    }

    public List<Componente> getComponentesByCategoria(String categoria) {
        return componenteRepository.findByCategoria(categoria);
    }

    public List<Componente> getComponentesPaginados(int pageNum, List<Componente> componentes){
        int pageSize = 10;
        int start = pageNum * pageSize;
        int end = Math.min((start + pageSize), componentes.size());
        if(start < end){
            return componentes.subList(start, end);
        }
        return null;
    }

    public int getNumPages(List<Componente> componentes){
        int pageSize = 10;
        return (int) Math.ceil((double) componentes.size() / pageSize);
    }


    public List<Componente> getcomponentesOrdenador(OrdenadorNewDto ordenador){
        List<Componente> componentes = new ArrayList<>();
        componentes.add(componenteRepository.findByNombre(ordenador.getCaja()));
        componentes.add(componenteRepository.findByNombre(ordenador.getPlaca()));
        componentes.add(componenteRepository.findByNombre(ordenador.getProcesador()));
        componentes.add(componenteRepository.findByNombre(ordenador.getRam()));
        componentes.add(componenteRepository.findByNombre(ordenador.getAlmacenamiento()));
        componentes.add(componenteRepository.findByNombre(ordenador.getFuente()));
        componentes.add(componenteRepository.findByNombre(ordenador.getTarjeta()));
        return componentes;
    }

    public Componente getComponenteById(Long id){
        return componenteRepository.findById(id).get();
    }


}