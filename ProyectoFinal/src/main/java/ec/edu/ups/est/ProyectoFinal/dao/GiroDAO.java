package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Giro;


@Stateless
public class GiroDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Giro op) {
		em.persist(op);
	}
	

	public void upgrade(Giro op) {

		em.merge(op);

	}
	
	public Giro read(int codigo ) {

		Giro op = em.find(Giro.class, codigo);
		return op;

	}

	public List<Giro> getList(){
		List<Giro> listado = new ArrayList<Giro>();
		
		String jpql="SELECT op FROM Giro op";
		Query query = em.createQuery(jpql, Giro.class);
		listado = query.getResultList();
		
		
		return listado;
	}
	
	
}
