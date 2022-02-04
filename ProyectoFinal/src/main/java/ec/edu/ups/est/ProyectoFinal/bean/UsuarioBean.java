package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.model.Credito;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;

@Named
@RequestScoped
public class UsuarioBean {
	
	@Inject
	private UsuarioON usuarioON;
	
	private String cedula;
	private List<Credito> creditos;
	private List<PagoServicio> servicios;

	public String getCedula() {
		return cedula;
	}

	public List<PagoServicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<PagoServicio> servicios) {
		this.servicios = servicios;
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
	public void loadServicios() {
		servicios = usuarioON.getUsuario(cedula).getPagoServicios();
	}

}
