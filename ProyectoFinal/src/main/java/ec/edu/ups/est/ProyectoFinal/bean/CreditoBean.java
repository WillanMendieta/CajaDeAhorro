package ec.edu.ups.est.ProyectoFinal.bean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private List<Map<String, String>> amortizaciones;
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
	
	public List<Map<String, String>> getAmortizaciones() {
		return amortizaciones;
	}
	public void setAmortizaciones(List<Map<String, String>> amortizaciones) {
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
		List<Map<String, String>> amortizacionesMapeadas = new ArrayList<Map<String,String>>();
		List<Amortizacion> amortizaciones = creditoON.cargarAmortizaciones(idCredito);
		int mesesParaSumar = 1;
		for (Amortizacion amortizacion : amortizaciones) {
			DecimalFormat df = new DecimalFormat("0.00");
			Map<String, String> amortizacionMapeada = new HashMap<String, String>();
			amortizacionMapeada.put("fechaPago", amortizacion.getFechaPago().toString());
			amortizacionMapeada.put("montoPagado", df.format(amortizacion.getMontoPagado()));
			amortizacionMapeada.put("fechaDebePagar", sumarMeses(amortizacion.getFechaPago(), mesesParaSumar).toString());
			amortizacionesMapeadas.add(amortizacionMapeada);
			mesesParaSumar++;
		}
		this.amortizaciones = amortizacionesMapeadas;
	}
	
	public void verificarBotonPago() {
		this.isButtonDisabled = creditoON.getCredito(idCredito).isEstaPagado();
	}
	
	private Date sumarMeses(Date fecha, int meses) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, meses);
		return calendar.getTime();
	}
}
