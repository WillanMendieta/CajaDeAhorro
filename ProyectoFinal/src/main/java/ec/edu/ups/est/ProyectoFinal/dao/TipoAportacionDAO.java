package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.TipoAportacion;

@Stateless
public class TipoAportacionDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(TipoAportacion ap) {
		em.persist(ap);
	}
	
	public TipoAportacion read(int id) {
		TipoAportacion ap = em.find(TipoAportacion.class, id);
		return ap;
	}
}
