package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class ClienteBean {
 
	private Usuario newusuario = new Usuario();
	private List<Usuario> usuarios;
	
	public Usuario getNewUsuario() {
		return newusuario;
	}
	
	public void setNewUsuario(Usuario newusuario) {
		this.newusuario = newusuario;
	}
	
	@Inject
	private UsuarioONLocal usuarioON;
	
	@PostConstruct
	public void init() {
		usuarios = usuarioON.getUsuarios();
		
	}
	
	public String guardarCliente() {
		try {
			this.newusuario.setTipoUsuario("Usuario");
			usuarioON.insertarUsuario(newusuario);
		}
		catch(Exception e){
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		
		return "mensaje-exito?faces-redirect=true&texto=Cliente Creado con exito";
	}
	
	public String guardarClienteAdmin() {
		try {
			usuarioON.insertarUsuario(newusuario);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "lista-usuarios?faces-redirect=true";
	}

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
