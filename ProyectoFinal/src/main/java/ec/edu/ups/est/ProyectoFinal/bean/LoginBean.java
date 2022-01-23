package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;

@Named
@RequestScoped
public class LoginBean {
	
	private String contra;
	private String cedula;
	
	@Inject
	private UsuarioON usuarioON;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		System.out.println("cedula");
		this.cedula = cedula;
	}

	public String getContra() {
		System.out.println("contra");
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
	public String login() {
		
		return null;
	}
}
