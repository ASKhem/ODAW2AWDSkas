package com.kas.kasproy.services.ordenador;

import java.util.List;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.model.product.Componente;
import com.kas.kasproy.model.product.Ordenador;

public interface OrdenadorService {
    public Ordenador createOrdenador(Ordenador ordenador);
    public List<Ordenador> getOrdenadores();
    public Ordenador getOrdenador(Long id);
    public void deleteOrdenador(Long id);
    public Ordenador convertToOrdenador(OrdenadorNewDto ordenadorNewDto);
    public OrdenadorNewDto convertToOrdenadorNewDto(Ordenador ordenador);
    public Double calcularPrecio(List<Componente> componentes);
}
