package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CreditoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Credito;

@Named
@RequestScoped
public class CreditoBean {
	@Inject
	private CreditoONLocal creditoON;
	
	private int numeroCuotas;
	private double cantidadCredito;
	private String cedulaPersona;
	
	public int getNumeroCuotas() {
		return numeroCuotas;
	}
	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	public double getCantidadCredito() {
		return cantidadCredito;
	}
	public void setCantidadCredito(double cantidadCredito) {
		this.cantidadCredito = cantidadCredito;
	}
	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}
	
	public String solicitarCredito() {
		try {
			Credito credito = new Credito();
			creditoON.solicitarCredito(cantidadCredito, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=No%20se%20ha%20podido%20solicitar";
		}
		return "mensaje-exito?faces-redirect=true&texto=Se%20ha%20solicitado%20con%20éxito";
	}
	
}
