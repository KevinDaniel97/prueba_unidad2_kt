package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaGestora;

public interface ICitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);
	public CitaMedica buscarPorId(Integer id);
	public void actualizar(CitaMedica citaMedica);	
	public void eliminar(Integer id);
	
	public CitaMedica buscarCitaNumero(String numero);
	public List<CitaMedicaGestora> citasMedicasReporte(LocalDateTime fecha,BigDecimal valor);

	
}
