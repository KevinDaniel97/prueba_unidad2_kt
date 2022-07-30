package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Doctor;

@Repository
@Transactional
public class DoctorRespositoryImpl implements IDoctorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);

	}

	@Override
	public Doctor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class,id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(buscarPorId(id));

	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM  Doctor p WHERE p.cedula = :datoCedula ");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Doctor) jpqlQuery.getSingleResult();
	}

	
}
