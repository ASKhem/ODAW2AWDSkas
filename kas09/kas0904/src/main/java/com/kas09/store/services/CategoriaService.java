package com.kas09.store.services;

import java.util.List;

import com.kas09.store.domain.Categoria;

public interface CategoriaService {
    List<Categoria> getCategorias();
    Categoria findById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(Long id);
}
