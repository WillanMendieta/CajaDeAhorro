package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.PolizaONLocal;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;
import ec.edu.ups.est.ProyectoFinal.model.Poliza;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;

@Named
@RequestScoped
public class PolizaUsuarioBean {
	@Inject
	private PolizaONLocal polizaON;

	@Inject
	private UsuarioONLocal usuarioON;
	
	private List<Poliza> polizas;
	private String numeroCuenta;
	
	@PostConstruct
	public void init() {
		this.loadPolizas();
	}
	
	public void loadDataPorCuenta() {
		if(this.numeroCuenta == null) 
			return;
		this.polizas = polizaON.getPolizasUsuario(this.numeroCuenta);
		
	}
	
	public List<Poliza> cargarMovimientosUsuario() {
		String cedula = SessionUtils.getUserCedula();
		String cuenta = usuarioON.getUsuario(cedula).getCuenta().getNumeroCuenta();
		return polizaON.getPolizasUsuario(cuenta);
	}
	
	public List<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	public void loadPolizas() {
		this.polizas = polizaON.getPolizas();
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


}
