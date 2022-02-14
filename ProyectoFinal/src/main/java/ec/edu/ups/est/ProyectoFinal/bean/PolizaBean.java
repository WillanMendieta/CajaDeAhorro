package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.PolizaONLocal;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Poliza;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;

@Named
@RequestScoped
public class PolizaBean {
	@Inject
	private PolizaONLocal polizaON;
	
	@Inject
	private CuentasONLocal cuentaON;
	
	@Inject
	private UsuarioONLocal usuarioON;

	private int numeroCuotas;
	private double cantidadInicio;
	private double cantidadFinal;
	private String cedulaPersona;
	private int idPoliza;
	// private List<Amortizacion> amortizaciones;
	private List<Poliza> polizas;
	private Poliza poliza = new Poliza();

	@PostConstruct
	public void init() {
		this.loadPoliza();
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public double getCantidadInicio() {
		return cantidadInicio;
	}

	public void setCantidadInicio(double cantidadInicio) {
		this.cantidadInicio = cantidadInicio;
	}

	public double getCantidadFinal() {
		return cantidadFinal;
	}

	public void setCantidadFinal(double cantidadFinal) {
		this.cantidadFinal = cantidadFinal;
	}

	public String getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public int getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
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

	public String verPolizas(String cedula) {
		return "ListaPolizas?faces-redirect=true&cedula=" + cedula;
	}

	public String calcularPoliza() {
		try {
			polizaON.generarPoliza(cantidadInicio, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		loadPoliza();
		return null;// "mensaje-exito?faces-redirect=true&texto=Se ha calculado la poliza con
					// éxito";
	}

	public String aceptarPoliza() {
		poliza.setInteres(0.05);
		try {
			poliza.setMontoCobrar(cantidadInicio * poliza.getInteres() + cantidadInicio);
			polizaON.aceptarPoliza(cantidadInicio, numeroCuotas, cedulaPersona);

			System.out.println("acepar Poliza");
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}

		return "mensaje-exito?faces-redirect=true&texto=Se ha generado la poliza con éxito usted recibira: "
				+ poliza.getMontoCobrar();
	}

	public String aceptarPolizaUsuario(String cedulaPersona) {
		poliza.setInteres(0.05);
		try {
			poliza.setMontoCobrar(cantidadInicio * poliza.getInteres() + cantidadInicio);
			polizaON.aceptarPoliza(cantidadInicio, numeroCuotas, cedulaPersona);

			System.out.println("acepar Poliza");
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}

		return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha generado la poliza con éxito usted recibira: "
				+ poliza.getMontoCobrar();
	}

	public void loadPoliza() {
		this.polizas = polizaON.getPolizas();
	}
	
	public String generarPolizaSesion() {
		String cedulaUsuario = SessionUtils.getUserCedula();
		String numerCuenta = usuarioON.getUsuario(cedulaUsuario).getCuenta().getNumeroCuenta();
		Cuenta cuenta = cuentaON.getCuenta(numerCuenta);
		if(cuenta == null) {
			return "mensaje-error-usuario?faces-redirect=true&texto=La cuenta no existe";
		}
			
		return aceptarPolizaUsuario(cedulaUsuario);	
		
	}

}
