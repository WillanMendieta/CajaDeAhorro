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
	
	public List<PagoServicio> getListPorCuenta(String numeroCuenta) {
		List<PagoServicio> listado = new ArrayList<PagoServicio>();
		String jpql = "SELECT op FROM PagoServicio op WHERE op.cuenta.numeroCuenta = ?1";
		Query query = em.createQuery(jpql, PagoServicio.class);
		query.setParameter(1, numeroCuenta);
		listado = query.getResultList();
		//System.out.println("LISTADOO!!!!! 0:      " + listado.get(0).getCuenta().getNumeroCuenta());
		return listado;
	}

}
