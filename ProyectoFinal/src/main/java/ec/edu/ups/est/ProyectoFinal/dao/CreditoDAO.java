package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Credito;

@Stateless
public class CreditoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Credito op) {
		em.persist(op);
	}
	
	public Credito read(int id) {
		Credito op = em.find(Credito.class, id);
		op.getAmortizaciones().size();
		return op;
	}
	
	public void upgrade(Credito op) {
		em.merge(op);
	}
	
	public void delete(int id) {
		Credito credito = em.find(Credito.class, id);
		em.remove(credito);
	}
	
	public List<Credito> getList() {		
		List<Credito> listado = new ArrayList<Credito>();
		String jpql = "SELECT op FROM Credito op";
		Query query = em.createQuery(jpql, Credito.class);
		listado = query.getResultList();
		return listado;
	}
	
}
