package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.Ciudad;

@Stateless
public class CiudadDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Ciudad op) {
		em.persist(op);
	}
	
	public Ciudad read(int codigo) {
		Ciudad c = em.find(Ciudad.class, codigo);
		return c;

	}
}
