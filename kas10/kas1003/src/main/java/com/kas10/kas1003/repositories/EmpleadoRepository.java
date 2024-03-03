package com.kas10.kas1003.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kas10.kas1003.domain.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findBySalarioGreaterThanEqualOrderBySalario(double salario);

    @Query("select e from Empleado e " +
            "where e.salario > (select avg (e2.salario) from Empleado e2)")
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}