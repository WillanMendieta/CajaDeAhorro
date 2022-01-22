package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.ups.est.ProyectoFinal.model.Movimiento;


@Stateless
public class MovimientoDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Movimiento op) {

		em.persist(op);

	}
	public List<Movimiento> getList() {		
		List<Movimiento> listado = new ArrayList<Movimiento>();
		String jpql = "SELECT op FROM Movimiento op";
		Query query = em.createQuery(jpql, Movimiento.class);
		listado = query.getResultList();
		return listado;
	}

}
