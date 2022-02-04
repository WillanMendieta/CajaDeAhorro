package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;



@Stateless
public class PagoServicioDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(PagoServicio ps) {
		em.persist(ps);

	}
	public PagoServicio read(int id) {
		PagoServicio ps = em.find(PagoServicio.class, id);
		return ps;
	}
	public void upgrade(PagoServicio ps) {
		em.merge(ps);
	}
	public List<PagoServicio> getList() {		
		List<PagoServicio> listado = new ArrayList<PagoServicio>();
		String jpql = "SELECT op FROM PagoServicio op";
		Query query = em.createQuery(jpql, PagoServicio.class);
		listado = query.getResultList();
		return listado;
	}
	

}
