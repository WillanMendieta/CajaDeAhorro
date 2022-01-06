package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.Movimiento;


@Stateless
public class MovimientoDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Movimiento op) {

		em.persist(op);

	}

}
