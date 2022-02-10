package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Cajero;

@Stateless
public class CajeroDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Cajero op) {
		em.persist(op);
	}
	
	public Cajero read(int codigo) {
		Cajero c = em.find(Cajero.class, codigo);
		return c;

	}
	
	public void update(Cajero op) {
		em.merge(op);
	}
	
	public List<Cajero> getList() {		
		List<Cajero> listado = new ArrayList<Cajero>();

		String jpql = "SELECT op FROM Cajero op";
		Query query = em.createQuery(jpql, Cajero.class);
		listado = query.getResultList();
		return listado;
	}


}
