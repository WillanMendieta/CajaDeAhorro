package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Cuenta;

@Stateless
public class CuentaDAO {
	@PersistenceContext
	private EntityManager em;

	public void insert(Cuenta op) {

		em.persist(op);
	}

	public List<Cuenta> getList() {

		List<Cuenta> listado = new ArrayList<Cuenta>();

		// No se hace consulta a la base sino a la entidad.
		String jpql = "SELECT op FROM Cuentas op";
		Query query = em.createQuery(jpql, Cuenta.class);
		listado = query.getResultList();

		// JPQL
		// Alternativa para SQL

		return listado;
	}

}