package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Doctor;
import com.uce.edu.demo.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepository iDoctorRespository;
	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRespository.insertar(doctor);
	}

	@Override
	public Doctor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iDoctorRespository.buscarPorId(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRespository.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iDoctorRespository.eliminar(id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iDoctorRespository.buscarPorCedula(cedula);
	}

}
