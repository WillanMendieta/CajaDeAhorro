package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Credito;

@Named
@RequestScoped
public class UsuarioBean {
	
	@Inject
	private UsuarioON usuarioON;
	
	private String cedula;
	private List<Credito> creditos;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	public void loadCreditos() {
		creditos = usuarioON.getUsuario(cedula).getCreditos();
	}

}
