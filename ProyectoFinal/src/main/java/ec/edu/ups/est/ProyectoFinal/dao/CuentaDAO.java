package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.Cuenta;

@Stateless
public class CuentaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cuenta op) {
		
		em.persist(op);
	}

}