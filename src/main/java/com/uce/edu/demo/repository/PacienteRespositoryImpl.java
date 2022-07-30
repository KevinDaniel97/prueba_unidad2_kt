package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Paciente;

@Repository
@Transactional
public class PacienteRespositoryImpl implements IPacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);

	}

	@Override
	public Paciente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(buscarPorId(id));

	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula= :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Paciente) jpqlQuery.getSingleResult();
	}
	
	
}
