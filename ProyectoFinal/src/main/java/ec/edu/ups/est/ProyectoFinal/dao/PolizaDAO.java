package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Poliza;


@Stateless
public class PolizaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Poliza op) {
		em.persist(op);
	}
	
	public void upgrade(Poliza op) {
		em.merge(op);
	}
	
	public Poliza read(int codigo ) {
		Poliza op = em.find(Poliza.class, codigo);
		return op;
	}

	public List<Poliza> getList(){
		List<Poliza> listado = new ArrayList<Poliza>();
		
		String jpql="SELECT op FROM Poliza op";
		Query query = em.createQuery(jpql, Poliza.class);
		listado = query.getResultList();
		
		return listado;
	}
	
	public List<Poliza> getListPorCuenta(String numeroCuenta){
		List<Poliza> listado = new ArrayList<Poliza>();
		String jpql = "SELECT op FROM Poliza op WHERE op.usuario.cuenta.numeroCuenta = ?1";
		Query query = em.createQuery(jpql, Poliza.class);
		query.setParameter(1, numeroCuenta);
		listado = query.getResultList();
		//System.out.println("LISTADOO!!!!! 0:      " + listado.get(0).getCuenta().getNumeroCuenta());
		return listado;
	}
	
	
}
