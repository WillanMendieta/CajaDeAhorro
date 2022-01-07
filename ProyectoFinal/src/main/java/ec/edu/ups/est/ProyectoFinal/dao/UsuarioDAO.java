package ec.edu.ups.est.ProyectoFinal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario op) {
		em.persist(op);
	}
	

	public void upgrade(Usuario op) {

		em.merge(op);

	}
	
	public Usuario read(String cedula) {

		Usuario op = em.find(Usuario.class, cedula);
		return op;

	}

	
	
	
	public List<Usuario> getList(){
		List<Usuario> listado = new ArrayList<Usuario>();
		
		String jpql="SELECT op FROM Usuario op";
		Query query = em.createQuery(jpql, Usuario.class);
		listado = query.getResultList();
		
		
		return listado;
	}
}
