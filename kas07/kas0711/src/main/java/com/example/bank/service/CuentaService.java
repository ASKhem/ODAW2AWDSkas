package com.example.bank.service;

import java.util.List;

import com.example.bank.model.Cuenta;
public interface CuentaService{
    public List<Cuenta> getCuentas();
    public Cuenta createCuenta(Cuenta cuenta);
    public Cuenta editCuenta(Cuenta cuenta);
    public void deleteCuenta(String iban);
    public Cuenta getCuenta(String iban);
    public void updateSaldo(Cuenta cuenta, Double cantidad);
}
