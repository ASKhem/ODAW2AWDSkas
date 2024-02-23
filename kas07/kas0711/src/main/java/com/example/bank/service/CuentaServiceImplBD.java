package com.example.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Cuenta;
import com.example.bank.repositories.CuentaRepository;

@Service
public class CuentaServiceImplBD implements CuentaService{
    
    @Autowired
    public CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta editCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(String iban) {
        cuentaRepository.deleteById(iban);
    }

    @Override
    public Cuenta getCuenta(String iban) {
        return cuentaRepository.findByIBAN(iban);
    }

    @Override
    public void updateSaldo(Cuenta cuenta, Double cantidad) {
        Cuenta cuentaUpdated = cuentaRepository.findByIBAN(cuenta.getIBAN());
        cuentaUpdated.setSaldo(cuenta.getSaldo() + cantidad);
        cuentaRepository.save(cuentaUpdated);
    }
}
