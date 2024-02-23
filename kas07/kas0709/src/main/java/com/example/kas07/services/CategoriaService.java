package com.example.kas07.services;

import java.util.List;

import com.example.kas07.domain.Categoria;

public interface CategoriaService {
    List<Categoria> getCategorias();
    Categoria findById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(Long id);
}
