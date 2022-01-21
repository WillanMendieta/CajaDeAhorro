package ec.edu.ups.est.ProyectoFinal.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;
@Stateless
public class TipoUsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TipoUsuario tu) {
		em.persist(tu);
	}
	
	public TipoUsuario read(int id) {
		TipoUsuario tu = em.find(TipoUsuario.class, id);
		return tu;
	}
}
