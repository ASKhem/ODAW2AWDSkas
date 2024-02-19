package com.kas08.kas0810.services;

import java.util.List;

import com.kas08.kas0810.domain.Categoria;

public interface CategoriaService {
    List<Categoria> getCategorias();
    Categoria findById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(Long id);
}
