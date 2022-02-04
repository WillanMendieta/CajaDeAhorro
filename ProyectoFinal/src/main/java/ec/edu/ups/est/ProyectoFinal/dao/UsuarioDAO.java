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
	
	
	public Usuario getSesion(String cedula, String contrasena) {
		List<Usuario> usuarios= new ArrayList<Usuario>();
		
		String jpql="SELECT op FROM Usuario op WHERE cedula=?1 AND contra=?2";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter(1, cedula);
		query.setParameter(2, contrasena);
		usuarios = query.getResultList();
		Usuario user= new Usuario();
		for(Usuario elemento: usuarios) {
			user=elemento;
		}
		return user;
	}
}
