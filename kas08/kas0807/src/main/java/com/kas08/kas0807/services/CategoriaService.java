package com.kas08.kas0807.services;

import java.util.List;

import com.kas08.kas0807.domain.Categoria;

public interface CategoriaService {
    List<Categoria> getCategorias();
    Categoria findById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(Long id);
}
