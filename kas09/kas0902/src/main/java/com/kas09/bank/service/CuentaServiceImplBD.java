package com.kas09.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kas09.bank.model.Cuenta;
import com.kas09.bank.repositories.CuentaRepository;

@Service
public class CuentaServiceImplBD implements CuentaService{
    
    @Autowired
    public CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getCuentas() {
        return cuentaRepository.findAll();
    }

    /*
        Algunos métodos de la interfaz CuentaService se les ha tenido que añadir 
        una comprobacion de que el objeto no es null debido a que sino nos aparece 
        un warning en la consola de que el objeto tiene que acomprobarse si es null
    */
    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        if(cuenta!=null) return cuentaRepository.save(cuenta);
        return null;
    }

    @Override
    public Cuenta editCuenta(Cuenta cuenta) {
        if(cuentaRepository.findByIBAN(cuenta.getIBAN())==null) return null;
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteCuenta(String iban) {
        if (iban != null) {
            cuentaRepository.deleteById(iban);
        }
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
