package com.kas10.kas1003.controllers;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.kas10.kas1003.domain.Empleado;
import com.kas10.kas1003.domain.Genero;
import com.kas10.kas1003.services.EmpleadoService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoControllerTest {
    ArrayList<Empleado> mockList;
    @InjectMocks
    EmpleadoController empleadoController;
    @MockBean
    EmpleadoService empleadoService;
    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "empleado1", "correo1@gmail.com", 1500d, false, Genero.HOMBRE, "/empleadoFotoPerfil/empleadoM.png"));
        mockList.add(new Empleado(2L, "empleado2", "correo2@gmail.com", 2000d, true, Genero.MUJER, "/empleadoFotoPerfil/empleadoF.png"));
    }
    
    @Test
    public void getListTest() throws Exception {
        when(empleadoService.obtenerTodos()).thenReturn(mockList);
        mockMvc.perform(get("/empleados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("empleado1")))
                .andExpect(jsonPath("$[1].nombre", is("empleado2")));
    }
    
    @Test
    public void getEmpleadoTest() throws Exception {
        when(empleadoService.obtenerPorId(1L)).thenReturn(mockList.get(0));
        mockMvc.perform(get("/empleado/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("empleado1")))
                .andExpect(jsonPath("$.salario", is(1500d)));
    }
}