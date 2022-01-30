package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class UsuarioON {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	public void insertarUsuario(Usuario u) throws Exception{
				
		usuarioDAO.insert(u);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioDAO.getList();
	}
	
	public Usuario getUsuario(String cedula) {
		return usuarioDAO.read(cedula);
	}
}
