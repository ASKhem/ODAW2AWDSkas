package com.kas09.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kas09.bank.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, String>{
    Cuenta findByIBAN(String iban);
}
