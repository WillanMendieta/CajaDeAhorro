package ec.edu.ups.est.ProyectoFinal.bean;

import java.text.DecimalFormat;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CreditoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;

@Named
@RequestScoped
public class CreditoBean {
	@Inject
	private CreditoONLocal creditoON;
	
	private int numeroCuotas;
	private double cantidadCredito;
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
	
	public List<Amortizacion> getAmortizaciones() {
		return amortizaciones;
	}
	
	public void setAmortizaciones(List<Amortizacion> amortizaciones) {
		this.amortizaciones = amortizaciones;
	}
	
	public String getDoubleFormatted(double amortizacion) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(amortizacion);
	}
	
	public String solicitarCredito() {
		try {
			creditoON.solicitarCredito(cantidadCredito, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha solicitado el crédito con éxito";
	}
	
	public String realizarPago() {
		try {
			creditoON.pagarCredito(idCredito);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "credito?faces-redirect=true&id=" + idCredito;
	}
	
	public void cargarAmortizaciones() {
		amortizaciones = creditoON.cargarAmortizaciones(idCredito);
	}
	
	public void verificarBotonPago() {
		this.isButtonDisabled = creditoON.getCredito(idCredito).isEstaPagado();
	}
}
