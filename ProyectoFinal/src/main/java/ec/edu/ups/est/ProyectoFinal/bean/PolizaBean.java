package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.PolizaONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;

@Named
@RequestScoped
public class PolizaBean {
	@Inject
	private PolizaONLocal polizaON;
	
	private int numeroCuotas;
	private double cantidadPoliza;
	private String cedulaPersona;
	private int idCredito;
	private List<Amortizacion> amortizaciones;
	private boolean isButtonDisabled = false;
	
	public boolean isButtonDisabled() {
		return isButtonDisabled;
	}
	public void setButtonDisabled(boolean isButtonDisabled) {
		this.isButtonDisabled = isButtonDisabled;
	}
	public int getIdCredito() {
		return idCredito;
	}
	public void setIdCredito(int idCredito) {
		this.idCredito = idCredito;
	}
	public int getNumeroCuotas() {
		return numeroCuotas;
	}
	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	public double getCantidadPoliza() {
		return cantidadPoliza;
	}
	public void setCantidadPoliza(double cantidadPoliza) {
		this.cantidadPoliza = cantidadPoliza;
	}
	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}
	
	public List<Amortizacion> getAmortizaciones() {
		return amortizaciones;
	}
	public void setAmortizaciones(List<Amortizacion> amortizaciones) {
		this.amortizaciones = amortizaciones;
	}
	
	public String solicitarCredito() {
		try {
			polizaON.solicitarPoliza(cantidadPoliza, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha generado la poliza con éxito";
	}
	
	public void verificarBotonPago() {
		this.isButtonDisabled = polizaON.getPoliza(idCredito).isEstaAprobado();
	}
}
