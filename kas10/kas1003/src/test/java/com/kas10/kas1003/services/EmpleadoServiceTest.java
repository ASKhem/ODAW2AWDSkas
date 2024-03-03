package com.kas10.kas1003.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.kas10.kas1003.domain.Empleado;
import com.kas10.kas1003.domain.Genero;
import com.kas10.kas1003.repositories.EmpleadoRepository;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoServiceTest {

    ArrayList<Empleado> mockList;

    @InjectMocks
    EmpleadoServiceImplBD empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;
    
    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "empleado1", "correo1@gmail.com", 1500d, false, Genero.HOMBRE, "/empleadoFotoPerfil/empleadoM.png"));
        mockList.add(new Empleado(2L, "empleado2", "correo2@gmail.com", 2000d, true, Genero.MUJER, "/empleadoFotoPerfil/empleadoF.png"));
    }

    @Test
    public void obtenerTodosTest() {
        when(empleadoRepository.findAll()).thenReturn(mockList);
        List<Empleado> empList = empleadoService.obtenerTodos();
        assertEquals(1, empList.size());
        assertTrue(empList.get(0).isEnActivo());
        verify(empleadoRepository, times(1)).findAll();
    }
}