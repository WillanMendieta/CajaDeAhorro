package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.PolizaONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;
import ec.edu.ups.est.ProyectoFinal.model.Poliza;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class PolizaBean {
	@Inject
	private PolizaONLocal polizaON;
	
	private int numeroCuotas;
	private double cantidadInicio;
	private double cantidadFinal;
	private String cedulaPersona;
	private int idPoliza;
	private List<Amortizacion> amortizaciones;
	private boolean isButtonDisabled = false;
	private Poliza poliza = new Poliza();
	
	private List<Poliza> polizas;
	
	public boolean isButtonDisabled() {
		return isButtonDisabled;
	}
	public void setButtonDisabled(boolean isButtonDisabled) {
		this.isButtonDisabled = isButtonDisabled;
	}
	public int getIdPoliza() {
		return idPoliza;
	}
	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
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
	
	public List<Poliza> getPoliza() {
		return polizas;
	}
	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}
	
	@PostConstruct
	public void init() {
		loadPoliza();
	}
	public String calcularPoliza() {
		try {
			polizaON.generarPoliza(cantidadInicio, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return null;//"mensaje-exito?faces-redirect=true&texto=Se ha calculado la poliza con éxito";
	}
	
	public String solicitarPoliza() {
		try {
			polizaON.solicitarPoliza(cantidadFinal, numeroCuotas, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha generado la poliza con éxito";
	}
	
	public void loadPoliza() {
		if(idPoliza == 0)
			return;
		Poliza poli = polizaON.getPoliza(idPoliza);
		poliza = poli;
		System.out.println(poliza.getMontoCobrar());
	}
	
	public void verificarBotonCalcular() {
		this.isButtonDisabled = polizaON.getPoliza(idPoliza).isEstaAprobado();
	}
}
