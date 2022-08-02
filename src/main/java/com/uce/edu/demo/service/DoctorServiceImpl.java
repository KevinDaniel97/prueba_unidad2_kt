package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public void insertar(Doctor doctor) {
		this.doctorRepository.insertar(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.doctorRepository.buscar(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		this.doctorRepository.eliminar(id);
	}

}
