package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Ciudad;

@Stateless
public class CiudadDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Ciudad op) {
		em.persist(op);
	}
	
	public Ciudad read(int codigo) {
		Ciudad c = em.find(Ciudad.class, codigo);
		return c;

	}
	
	public List<Ciudad>  singleCiudad(String nombre) {
		String jpql="SELECT op FROM Ciudad WHERE nombre = ?1";
		Query query = em.createQuery(jpql, Ciudad.class);
		query.setParameter(1, nombre);
		
		List<Ciudad> ciudad = query.getResultList();
		return ciudad;
	}
	
	public List<Ciudad> getList() {		
		List<Ciudad> listado = new ArrayList<Ciudad>();
		String jpql = "SELECT op FROM Ciudad op";
		Query query = em.createQuery(jpql, Ciudad.class);
		listado = query.getResultList();
		return listado;
	}
	
	
	public void update(Ciudad op) {
		em.merge(op);
	}

}
