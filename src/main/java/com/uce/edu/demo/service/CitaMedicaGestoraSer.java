package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaGestora;
import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.repository.ICitaMedicaRepository;

@Service
public class CitaMedicaGestoraSer implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;
	
	@Autowired
	private IDoctorService iDoctorService;
	
	@Autowired
	private IPacienteService iPacienteService;
	@Override
	public void agendarCita(String numero, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
	
		Doctor  docotor1= this.iDoctorService.buscarPorCedula(cedulaPaciente);
		Paciente paciente1=this.iPacienteService.buscarPorCedula(cedulaPaciente);
		
		CitaMedica citaMedica1= new CitaMedica();
		citaMedica1.setNumero(numero);
		citaMedica1.setFechaCita(fechaCita);
		citaMedica1.setCostoCita(costoCita);
		citaMedica1.setLugarCita(lugarCita);
		citaMedica1.setDoctor(docotor1);
		citaMedica1.setPaciente(paciente1);
		
		this.iCitaMedicaRepository.insertar(citaMedica1);
		
	}
	
	@Override
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub
		
		CitaMedica citaMedica1= this.iCitaMedicaRepository.buscarCitaNumero(numero);
		citaMedica1.setNumero(numero);
		citaMedica1.setDiagnostico(diagnostico);
		citaMedica1.setReceta(receta);
		citaMedica1.setFechaControl(fechaControl);
		this.iCitaMedicaRepository.actualizar(citaMedica1);
	}

	@Override
	public List<CitaMedicaGestora> citasMedicasReporte(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepository.citasMedicasReporte(fecha, costo);
	}
	
	
}
