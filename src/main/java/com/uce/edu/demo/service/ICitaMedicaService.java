package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaGestora;

public interface ICitaMedicaService {


	
	public CitaMedica agendarCita(String numero,LocalDateTime fechaCita,BigDecimal valorCita, String lugarCita, String cedulaDoctor, String cedulaPaciente);
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl);
	public List<CitaMedicaGestora> citasMedicasReporte(LocalDateTime fecha,BigDecimal valor);

}
