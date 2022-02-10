package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.MovimientoONLocal;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioON;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Credito;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;

@Named
@RequestScoped
public class UsuarioBean {
	
	@Inject
	private UsuarioONLocal usuarioON;
	
	@Inject
	private MovimientoONLocal movimientoON;
	
	private String cedula;
	private String cedulaSesion=SessionUtils.getUserCedula();
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
	public void loadServiciosSesion() {
		servicios = usuarioON.getUsuario(cedulaSesion).getPagoServicios();
	}
	
	public List<Movimiento> getMovimientosCuentaDeUsuario() {
		String numeroCuenta = usuarioON.getUsuario(cedula).getCuenta().getNumeroCuenta();
		return movimientoON.getMovimientosPorCuenta(numeroCuenta);
	}
	
	public double getSaldoCuentaDeUsuario() {
		return usuarioON.getUsuario(cedula).getCuenta().getSaldo();
	}

	public String getCedulaSesion() {
		return cedulaSesion;
	}



	
}
