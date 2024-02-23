package com.example.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{
    Cuenta findByIBAN(String iban);
}
