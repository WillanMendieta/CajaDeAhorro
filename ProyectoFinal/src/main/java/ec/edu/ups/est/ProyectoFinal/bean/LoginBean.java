package ec.edu.ups.est.ProyectoFinal.bean;



import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	private String contra;
	private String cedula;
	
	@Inject
	private UsuarioON usuarioON;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		System.out.println("cedula"+ this.cedula);
		this.cedula = cedula;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		System.out.println("contra"+ this.contra);
		this.contra = contra;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() {
		System.out.println(" "+ this.cedula);
		//this.usuario.setCedula(this.cedula);
		//this.usuario = usuarioON.getUsuario(cedula);
		this.usuario=usuarioON.validarSesion(cedula, contra);
		System.out.println(this.usuario);
		if(this.usuario !=  null & this.usuario.getTipoUsuario().equalsIgnoreCase("Admin")) {
			return "PageAdmin?faces-redirect=true&cedula=" + cedula;
		}
		if(this.usuario != null & this.usuario.getTipoUsuario().equalsIgnoreCase("Usuario")) {
			return "index?faces-redirect=true&cedula=" + cedula;
		}else {
			System.out.println(this.usuario.getNombre());
			return "Login?faces-redirect=true";
		}
		
		//return "PageAdmin?faces-redirect=true&cedula=" + cedula;
	}
	
	public void loadUsuario() {
		if(cedula ==null)
			return;
		Usuario usu = usuarioON.getUsuario(cedula);
		usuario = usu;
		System.out.println(usuario.getNombre());
	}
}
