package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaGestor;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2 implements CommandLineRunner{
	private static Logger log = Logger.getLogger(PruebaUnidad2.class);
	
	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaMedicaGestor citaMedicaGestor;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Doctor doctor1 = new Doctor();
		doctor1.setNombre("kev");
		doctor1.setApellido("apw");
		doctor1.setCedula("1");
		doctor1.setCodigoSenescyt("10");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setNumeroConsultorio("10");
		doctor1.setGenero("M");
		
		Doctor doctor2 = new Doctor();
		doctor2.setNombre("bbb");
		doctor2.setApellido("aaa");
		doctor2.setCedula("12");
		doctor2.setCodigoSenescyt("11");
		doctor2.setFechaNacimiento(LocalDateTime.now());
		doctor2.setNumeroConsultorio("14");
		doctor2.setGenero("M");

		this.doctorService.insertar(doctor1);
		this.doctorService.insertar(doctor2);
		
		Paciente paciente1 = new Paciente();
		paciente1.setNombre("dan");
		paciente1.setApellido("dark");
		paciente1.setCedula("12");
		paciente1.setFechaNacimiento(LocalDateTime.now());
		paciente1.setGenero("M");
		
		Paciente paciente2 = new Paciente();
		paciente2.setNombre("ee");
		paciente2.setApellido("Sussarez");
		paciente2.setCedula("14");
		paciente2.setFechaNacimiento(LocalDateTime.now());
		paciente2.setGenero("M");
		
		
		paciente1.setCedula("12");
		paciente2.setCedula("14");
		
		this.pacienteService.insertar(paciente1);
		this.pacienteService.insertar(paciente2);
		
		this.citaMedicaGestor.agendamientoCitaMedica("12", LocalDateTime.now(), null, null, null, null);
		//this.citaMedicaGestor.actualizacionCitaMedica("1", null, null, null);
	}

}