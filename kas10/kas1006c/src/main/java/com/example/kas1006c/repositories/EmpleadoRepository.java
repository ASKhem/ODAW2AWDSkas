package com.example.kas1006c.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.kas1006c.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findBySalarioGreaterThanEqualOrderBySalario(double salario);

    @Query("select e from Empleado e " +
            "where e.salario > (select avg (e2.salario) from Empleado e2)")
    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}
