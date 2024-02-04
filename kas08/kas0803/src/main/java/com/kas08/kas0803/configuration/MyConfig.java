package com.kas08.kas0803.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    /*
    * ModelMapper es una librería que nos permite mapear objetos de un tipo a otro.
    * En este caso, lo utilizaremos para mapear los objetos de tipo Empleado a EmpleadoDTO y viceversa.
    */
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
