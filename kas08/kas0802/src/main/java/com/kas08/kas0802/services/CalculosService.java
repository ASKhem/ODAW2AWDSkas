package com.kas08.kas0802.services;

import java.util.TreeSet;

public interface CalculosService {
    public boolean calcularPrimo(Integer num);
    public int calcularHipotenusa(Integer X, Integer Y);
    public TreeSet<Integer> calcularRepetidos(Integer X);
    public TreeSet<Integer> calculoDivisores(Integer X);
}
