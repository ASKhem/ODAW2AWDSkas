package com.kas.kasproy.services.componente;

import java.util.List;

import com.kas.kasproy.dto.OrdenadorNewDto;
import com.kas.kasproy.model.product.Componente;

public interface ComponenteService {
    public List<Componente> getComponentes();
    public Componente getComponente(Long id);
    public Componente createComponente(Componente componente);
    public void deleteComponente(Long id);
    public Componente updateComponente(Long id, Componente componente);
    public List<Componente> getComponentesByCategoria(String categoria);
    public List<Componente> getComponentesPaginados(int pageNum, List<Componente> componentes);
    public int getNumPages(List<Componente> componentes);
    public List<Componente> getcomponentesOrdenador(OrdenadorNewDto ordenador);
}

