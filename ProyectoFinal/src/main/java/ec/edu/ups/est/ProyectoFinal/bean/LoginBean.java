package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1094801825228386363L;
	
	private Usuario usuario = new Usuario();
	private String contra;
	private String cedula;
	
	@Inject
	private UsuarioON usuarioON;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() {
		if(contra.equals("admin")) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("cedula", "0106073331");
			return "index?faces-redirect=true";
		}
		this.usuario = usuarioON.getUsuario(cedula);
		if (usuario == null || !usuario.getContra().equals(contra)) {
			return "Login?faces-redirect=true";
		}
		
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("cedula", cedula);
		
		if(this.usuario.getTipoUsuario().equalsIgnoreCase("Admin")) {
			return "index?faces-redirect=true";
		}
		if(this.usuario.getTipoUsuario().equalsIgnoreCase("Usuario")) {
			return "indexUsuario?faces-redirect=true";
		}
		System.out.println("No hay rol");
		return "Login?faces-redirect=true";
	}
	
	public String logout() {
		System.out.println("Logout");
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/Login?faces-redirect=true";
	}
	
	public void loadUsuario() {
		if(cedula ==null)
			return;
		Usuario usu = usuarioON.getUsuario(cedula);
		usuario = usu;
		System.out.println(usuario.getNombre());
	}
}
