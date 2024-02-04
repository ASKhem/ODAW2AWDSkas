package com.kas08.kas0802.services;

import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class CalculosServiceImpl implements CalculosService{
    @Override
    public boolean calcularPrimo(Integer num) {
        for (int i = num - 1; i > 1; i--) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int calcularHipotenusa(Integer X, Integer Y) {
        return (int) Math.hypot(X, Y);
    }

    @Override
    public TreeSet<Integer> calcularRepetidos(Integer X) {
        TreeSet<Integer> listaNumeros = new TreeSet<>();
        Random random = new Random();
        while (!(listaNumeros.size() == X)) {
            for (int i = 0; i < X; i++) {
                listaNumeros.add(random.nextInt(100) + 1);
            }
        }
        return listaNumeros;
    }

    @Override
    public TreeSet<Integer> calculoDivisores(Integer X) {
        TreeSet<Integer> divisores = new TreeSet<>();
        for (int i = X - 1; i <= X && i > 0; i--) {
            if (X % i == 0) {
                divisores.add(i);
            }
        }
        return divisores;
    }
}
