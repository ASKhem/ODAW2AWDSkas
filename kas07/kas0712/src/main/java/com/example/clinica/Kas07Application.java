package com.example.clinica;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.clinica.domain.PacienteDTO;
import com.example.clinica.service.PacienteService;

@SpringBootApplication
public class Kas07Application {

	public static void main(String[] args) {
		SpringApplication.run(Kas07Application.class, args);
	}

	@Bean
	public CommandLineRunner initData(PacienteService repository) {
		return (args) -> {
			//Paciente1
			PacienteDTO pacienteDTO = new PacienteDTO();
			pacienteDTO.setDni("12345678A");
			pacienteDTO.setNombre("Pedro");
			pacienteDTO.setFechaNacimiento(LocalDate.of(1990, 1, 1));
			pacienteDTO.setTipoPaciente(1);
			pacienteDTO.setMotivoConsulta("Revision anual");
			repository.add(repository.buildPacientefromDTO(pacienteDTO));
			//Paciente2
			pacienteDTO = new PacienteDTO();
			pacienteDTO.setDni("23456789B");
			pacienteDTO.setNombre("Juan");
			pacienteDTO.setFechaNacimiento(LocalDate.of(2000, 1, 1));
			pacienteDTO.setFechaUltimaRevision(LocalDate.of(2020, 1, 1));
			pacienteDTO.setTipoPaciente(3);
			repository.add(repository.buildPacientefromDTO(pacienteDTO));
			//Paciente3
			pacienteDTO = new PacienteDTO();
			pacienteDTO.setDni("34567890C");
			pacienteDTO.setNombre("Maria");
			pacienteDTO.setFechaNacimiento(LocalDate.of(2010, 1, 1));
			pacienteDTO.setTipoPaciente(2);
			pacienteDTO.setListaMedicamentos(3);
			repository.add(repository.buildPacientefromDTO(pacienteDTO));
		};
	}

}
