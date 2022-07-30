package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Paciente;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);
	public Paciente buscarPorId(Integer id);
	public void actualizar(Paciente paciente);	
	public void eliminar(Integer id);
	public Paciente buscarPorCedula(String cedula);

}
