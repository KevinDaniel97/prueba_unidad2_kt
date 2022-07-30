package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaGestora;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.service.ICitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2 implements CommandLineRunner{
	private static Logger log = Logger.getLogger(PruebaUnidad2.class);
	
	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private ICitaMedicaService iCitaMedicaService;
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1
		Doctor doc =new Doctor();
		doc.setCedula("150");
		doc.setNombre("Dario");
		doc.setApellido("Teran");
		doc.setFechaNacimiento(LocalDateTime.of(2000, 11,10,0,0));
		doc.setNumConsultorio("01");
		doc.setTitulo("Psicologia");
		doc.setSalario(new BigDecimal(1000));
		this.iDoctorService.insertar(doc);
		
		Doctor doc2 =new Doctor();
		doc2.setCedula("151");
		doc2.setNombre("Darki");
		doc2.setApellido("Tenorio");
		doc2.setFechaNacimiento(LocalDateTime.of(1997, 10,10,0,0));
		doc2.setNumConsultorio("04");
		doc2.setTitulo("general");
		doc2.setSalario(new BigDecimal(700));
		this.iDoctorService.insertar(doc2);

		//2
		Paciente paciente1=new Paciente();
		paciente1.setNombre("kevin");
		paciente1.setApellido("Toapanta");
		paciente1.setCedula("100");
		paciente1.setFechaNaciento(LocalDateTime.of(2007, 12,10,0,0));
		paciente1.setCodIess("200");
		paciente1.setEstatura("169.5 cm");
		paciente1.setPeso("62 kg");
		paciente1.setGenero("M");
		this.iPacienteService.insertar(paciente1);
		
		Paciente paciente2=new Paciente();
		paciente2.setNombre("daniel");
		paciente2.setApellido("rodrig");
		paciente2.setCedula("101");
		paciente2.setFechaNaciento(LocalDateTime.of(2007, 12,10,0,0));
		paciente2.setCodIess("201");
		paciente2.setEstatura("170.5 cm");
		paciente2.setPeso("72 kg");
		paciente2.setGenero("M");
		this.iPacienteService.insertar(paciente2);
	

		//3
		//CitaMedica cita1= this.iCitaMedicaService.agendarCita("10", LocalDateTime.of(2007, 12,10,0,0), new BigDecimal(10), "quito", "150","100" );
		//4
		//this.iCitaMedicaService.actualizarCitaMedica("99","calor","tomar agua", LocalDateTime.now());
		//5
		//this.iCitaMedicaService.citasMedicasReporte(LocalDateTime.now(), new BigDecimal(5));
		
	}
	

}
