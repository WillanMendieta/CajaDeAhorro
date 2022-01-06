package ec.edu.ups.est.ProyectoFinal.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class ClienteBean {
 
	private Usuario newusuario = new Usuario();
	private List<Usuario> usuarios;
	
	public Usuario geUsuario() {
		return newusuario;
	}
	
	public void setNewUsuario(Usuario usuario) {
		this.newusuario = newusuario;
	}
	
	@Inject
	private UsuarioON usuarioON;
	
	@PostConstruct
	public void init() {
		usuarios = usuarioON.get
	}

	
}
