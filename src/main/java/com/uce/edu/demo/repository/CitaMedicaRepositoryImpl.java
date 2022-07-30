package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.CitaMedica;
import com.uce.edu.demo.modelo.CitaMedicaGestora;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{


	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(buscarPorId(id));
	}

	@Override
	public CitaMedica buscarCitaNumero(String numero) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM CitaMedica p WHERE p.numero= :datoNumero");
		jpqlQuery.setParameter("datoNumero", numero);
		return (CitaMedica) jpqlQuery.getSingleResult();
	}

	@Override
	public List<CitaMedicaGestora> citasMedicasReporte(LocalDateTime fecha, BigDecimal costo) {
		
		TypedQuery<CitaMedicaGestora> jpqlQuery = this.entityManager.createQuery("SELECT new com.uce.edu.demo.modelo.CitaMedicaGestora(p.numero,p.fechaCita,p.valorCita,p.fechaControl) FROM CitaMedica p WHERE p.fecha > :datoFecha AND p.costo  >:datoCosto",CitaMedicaGestora.class);
		jpqlQuery.setParameter("datoFecha", fecha);
		jpqlQuery.setParameter("datoCosto", costo);
		return jpqlQuery.getResultList();
	}

}
