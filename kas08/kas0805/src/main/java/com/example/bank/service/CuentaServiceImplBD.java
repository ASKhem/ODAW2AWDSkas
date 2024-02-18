package com.example.bank.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.dtos.NewCuentaDto;
import com.example.bank.exceptions.EmptyAccountsListException;
import com.example.bank.exceptions.NotEmptyMovementsAccount;
import com.example.bank.exceptions.NotFoundAccountException;
import com.example.bank.model.Cuenta;
import com.example.bank.repositories.CuentaRepository;

@Service
public class CuentaServiceImplBD implements CuentaService{
    
    @Autowired
    public CuentaRepository cuentaRepository;

    @Autowired
    public ModelMapper modelMapper;

    public List<Cuenta> getCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        if(cuentas.isEmpty()){
            throw new EmptyAccountsListException();
        }
        return cuentas;
    }

    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta editCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(String iban, boolean movimientos) {
        if(movimientos){
            throw new NotEmptyMovementsAccount();
        }
        Cuenta cuenta = cuentaRepository.findById(iban).orElseThrow(() -> new NotFoundAccountException());
        cuentaRepository.delete(cuenta);
    }

    public Cuenta getCuenta(String iban) {
        return cuentaRepository.findByIBAN(iban);
    }

    public void updateSaldo(Cuenta cuenta, Double cantidad) {
        Cuenta cuentaUpdated = cuentaRepository.findByIBAN(cuenta.getIBAN());
        cuentaUpdated.setSaldo(cuenta.getSaldo() + cantidad);
        cuentaRepository.save(cuentaUpdated);
    }

    public Cuenta convertDtoToCuenta(NewCuentaDto cuentaDto){
        Cuenta cuenta = modelMapper.map(cuentaDto, Cuenta.class);
        return cuenta;
    }
}
