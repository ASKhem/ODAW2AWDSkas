package com.example.kas07.services;

import java.util.List;

public interface HelperService <E>{
    public E añadir(E e);
    public E obtenerPorId(Long id);
    public E editar(E e);
    public void borrar(Long id);
    public List<E> obtenerTodos();
}
