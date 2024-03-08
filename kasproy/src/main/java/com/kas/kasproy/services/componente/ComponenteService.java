package com.kas.kasproy.services.componente;

import java.util.List;

import com.kas.kasproy.model.product.Componente;

public interface ComponenteService {
    public List<Componente> getComponentes();
    public Componente getComponente(Long id);
    public Componente createComponente(Componente componente);
    public void deleteComponente(Long id);
    public Componente updateComponente(Long id, Componente componente);
}

