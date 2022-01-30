package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class UsuariosBean {
	@Inject
	private UsuarioON usuarioON;
	
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init() {
		this.loadCuentas();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void loadCuentas() {
		this.usuarios = usuarioON.getUsuarios();
	}
	
	public String verUsuario(String cedula) {
		return "usuario?faces-redirect=true&cedula=" + cedula;
	}

}
