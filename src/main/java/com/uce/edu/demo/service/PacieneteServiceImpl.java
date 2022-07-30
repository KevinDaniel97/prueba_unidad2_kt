package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.Paciente;
import com.uce.edu.demo.repository.IPacienteRepository;

@Service
public class PacieneteServiceImpl implements IPacienteService{

	 @Autowired
	 private IPacienteRepository iPacienteRepository;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.insertar(paciente);
	}

	@Override
	public Paciente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.buscarPorId(id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPacienteRepository.eliminar(id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return iPacienteRepository.buscarPorCedula(cedula);
	}

	

//	@Override
//	public CitaMedica buscarCitaNumero(String numero) {
//		// TODO Auto-generated method stub
//		return this.iPacienteRepository.buscarPorCedula(numero);
//	}
//	

}
