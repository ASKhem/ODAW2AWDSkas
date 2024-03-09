package com.kas.kasproy.services.ordenador;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.model.product.Componente;
import com.kas.kasproy.model.product.Ordenador;
import com.kas.kasproy.repositories.OrdenadorRepository;

@Service
public class OrdenadorServiceImpl  implements OrdenadorService {
    @Autowired
    OrdenadorRepository ordenadorRepository;

    @Autowired
    ModelMapper modelMapper;

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

    public Ordenador convertToOrdenador(OrdenadorNewDto ordenadorNewDto){
        Ordenador ordenador = modelMapper.map(ordenadorNewDto, Ordenador.class);
        return ordenadorRepository.save(ordenador);
    }

    public OrdenadorNewDto convertToOrdenadorNewDto(Ordenador ordenador){
        return modelMapper.map(ordenador, OrdenadorNewDto.class);
    }

    public Double calcularPrecio(List<Componente> componentes){
        Double precio = 0.0;
        for (Componente c : componentes) {
            precio += Double.parseDouble(c.getPrecio());
        }
        return precio;
    }
}
