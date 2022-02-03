package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.Servicio;


@Stateless
public class ServicioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Servicio se) {
		em.persist(se);
	}
	
	public Servicio read(int id) {
		Servicio se = em.find(Servicio.class, id);
		return se;
	}
}
