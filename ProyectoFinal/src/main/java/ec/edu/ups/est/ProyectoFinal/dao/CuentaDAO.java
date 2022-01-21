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
	
	public Cuenta read(String numero) {

		Cuenta op = em.find(Cuenta.class, numero);
		return op;

	}
	
	public void upgrade(Cuenta op) {
		em.merge(op);
	}

	public List<Cuenta> getList() {		
		List<Cuenta> listado = new ArrayList<Cuenta>();

		String jpql = "SELECT op FROM Cuenta op";
		Query query = em.createQuery(jpql, Cuenta.class);
		listado = query.getResultList();
		return listado;
	}

}