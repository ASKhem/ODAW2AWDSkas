package com.kas.kasproy.services.ordenador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.model.product.Ordenador;
import com.kas.kasproy.repositories.OrdenadorRepository;

@Service
public class OrdenadorServiceImpl  implements OrdenadorService {
    @Autowired
    OrdenadorRepository ordenadorRepository;

    public Ordenador createOrdenador(Ordenador ordenador){
        return ordenadorRepository.save(ordenador);
    }
    public List<Ordenador> getOrdenadores(){
        return ordenadorRepository.findAll();
    }
    public Ordenador getOrdenador(Long id){
        return ordenadorRepository.findById(id).get();
    }
    public void deleteOrdenador(Long id){
        ordenadorRepository.deleteById(id);
    };
}
