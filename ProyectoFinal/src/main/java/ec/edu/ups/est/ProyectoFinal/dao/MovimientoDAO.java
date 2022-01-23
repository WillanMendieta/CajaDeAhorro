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
	
	public List<Movimiento> getListPorCuenta(String numeroCuenta) {
		List<Movimiento> listado = new ArrayList<Movimiento>();
		String jpql = "SELECT op FROM Movimiento op WHERE op.cuenta.numeroCuenta = ?1";
		Query query = em.createQuery(jpql, Movimiento.class);
		query.setParameter(1, numeroCuenta);
		listado = query.getResultList();
		System.out.println("LISTADOO!!!!! 0:      " + listado.get(0).getCuenta().getNumeroCuenta());
		return listado;
	}

}
