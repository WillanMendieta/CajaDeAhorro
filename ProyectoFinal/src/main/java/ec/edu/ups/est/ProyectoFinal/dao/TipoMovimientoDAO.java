package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.TipoMovimiento;

@Stateless
public class TipoMovimientoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TipoMovimiento op) {
		em.persist(op);
	}
	
	public TipoMovimiento read(int id) {
		TipoMovimiento op = em.find(TipoMovimiento.class, id);
		return op;
	}
	
}
