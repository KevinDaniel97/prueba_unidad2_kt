package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Paciente;

public interface IPacienteService {

	public void insertar(Paciente paciente);
	public Paciente buscarPorId(Integer id);
	public void actualizar(Paciente paciente);	
	public void eliminar(Integer id);
	public Paciente buscarPorCedula(String cedula);


}
